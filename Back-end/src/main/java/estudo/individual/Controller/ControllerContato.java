package estudo.individual.Controller;

import estudo.individual.Model.Contato;
import estudo.individual.Service.ServiceContato;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ControllerContato {

    @Autowired
    ServiceContato serviceContato;



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView listarContatos(){
        ModelAndView modelAndView = new ModelAndView("index");
        List<Contato> contatos = serviceContato.listarContatos();
        modelAndView.addObject("contatos", contatos);
        return modelAndView;
    }
    @RequestMapping("/cadastrar")
    public ModelAndView cadastrarContato(){
        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject(new Contato());
        return modelAndView;
    }



    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public ModelAndView salvarContato(@Validated Contato contato, Errors errors){
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        if(errors.hasErrors()){return modelAndView;}
        serviceContato.salvarContato(contato);
        return modelAndView;
    }

   @RequestMapping(value = "/excluir/{id}")
    public String excluirContato(@PathVariable("id") Integer id){
        serviceContato.excluirContato(id);
        return "redirect:/";


    }
    @RequestMapping(value = "/{id}")
    public ModelAndView atualizarContato(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("cadastro");
        Contato contato = serviceContato.getContato(id);
        modelAndView.addObject(contato);
        return modelAndView;
    }


}
