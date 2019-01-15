package br.ifpe.pg.provacolegiada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/questoes/")
public class QuestaoController {

//    @Autowired
//    private QuestaoService questaoService;

    @GetMapping("list")
    public ModelAndView exibirLista() {
        ModelAndView mv = new ModelAndView("cadastros/questoes-list");
//        mv.addObject("lista", questaoService.listarTodos());
        return mv;
    }
}
