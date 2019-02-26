package estudo.individual.Service;

import estudo.individual.Model.Contato;
import estudo.individual.Repository.RepositoryContato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class ServiceContato {

    @Autowired
    RepositoryContato repositoryContato;

    public List<Contato> listarContatos(){
        return repositoryContato.findAll();
    }

    public Contato getContato(Integer id){
        return repositoryContato.findOne(id);
    }

    public void salvarContato(Contato contato){
        repositoryContato.save(contato);
    }

    public void excluirContato(Integer id){
        repositoryContato.delete(id);
    }
    public void atualizarContato(Integer id, Contato contato){
        if(repositoryContato.findOne(id) != null){
            repositoryContato.save(contato);
        }

    }

}



