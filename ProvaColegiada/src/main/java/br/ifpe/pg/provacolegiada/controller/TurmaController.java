package br.ifpe.pg.provacolegiada.controller;

import br.ifpe.pg.provacolegiada.model.enumerator.ETurno;
import br.ifpe.pg.provacolegiada.service.CursoService;
import br.ifpe.pg.provacolegiada.service.TurmaService;
import br.ifpe.pg.provacolegiada.model.enumerator.ESituacao;
import br.ifpe.pg.provacolegiada.model.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/turmas/")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;
    @Autowired
    private CursoService cursoService;

    @RequestMapping(value = "saveList", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView salvarPesquisarTurma(@Valid @ModelAttribute Turma turma, @RequestParam(value = "action",
            required = false) String action, Errors errors, RedirectAttributes ra) {

        if (action != null && action.equals("salvar")) {
            return salvar(turma, errors, ra);
        } else {
            return pesquisar(turma, ra);
        }
    }

    @GetMapping("list")
    public ModelAndView pesquisar(Turma turma, RedirectAttributes ra) {
        ModelAndView mv = new ModelAndView("cadastros/turmas-list");
        if (turma == null || turma.getId() == null) {
            mv.addObject("lista", turmaService.listarTodas());
        } else {
            mv.addObject("lista", turmaService.buscarPorCurso(turma.getCurso()));
        }
        mv.addObject("listaCursos", cursoService.listarCursosCustomizados());
        mv.addObject("listaTurnos", ETurno.values());
        mv.addObject("turma", turma);
        mv.addObject("listaSituacao", ESituacao.values());

        //setando mensagens de erro no template
        mv.addObject("mensagemErro", ra.getFlashAttributes().get("mensagemErro"));
        mv.addObject("mensagemSucesso", ra.getFlashAttributes().get("mensagemSucesso"));
        return mv;
    }

    private ModelAndView salvar(@Valid @ModelAttribute Turma turma, Errors errors, RedirectAttributes ra) {
        if (errors.hasErrors()) {
            ra.addFlashAttribute("mensagemErro", "Não foi possível salvar turma: " + errors.getFieldErrors());
        } else {
            try {
                turmaService.salvar(turma);
                ra.addFlashAttribute("mensagemSucesso", "Turma salva com sucesso");
            } catch (Exception e) {
                ra.addFlashAttribute("mensagemErro", "Não foi possível salvar turma: " + e.getMessage());
            }
        }
        return pesquisar(new Turma(), ra);
    }

    @GetMapping("edit/{id}")
    public ModelAndView exibirEdicao(@PathVariable("id") Integer id) {
        Turma turma = turmaService.buscarPorId(id);
        ModelAndView mv = new ModelAndView("cadastros/turmas-list");
        mv.addObject("lista", turmaService.listarTodas());
        mv.addObject("listaCursos", cursoService.listarTodos());
        mv.addObject("listaTurnos", ETurno.values());
        mv.addObject("turma", turma);
        return mv;
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable("id") Integer id, RedirectAttributes ra) {
        turmaService.removerPorId(id);
        ra.addFlashAttribute("mensagemSucesso", "Turma removida com sucesso");
        return "redirect:/turmas/list";
    }

}
