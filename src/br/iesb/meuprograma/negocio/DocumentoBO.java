package br.iesb.meuprograma.negocio;

import br.iesb.meuprograma.dados.Usuario;
import java.util.ArrayList;
import java.util.List;

public class DocumentoBO implements BO<Usuario> {

    @Override
    public void validar(Usuario entidade) throws NegocioException {
        if (entidade.getUsername().isEmpty()) {
            throw new NegocioException("O campo Username é obrigatório");
        }
        
      
        if (entidade.getPassword().isEmpty()) {
            throw new NegocioException("O campo Password é obrigatório");
        }
        
        if (!entidade.getPassword().contains("admin") && !entidade.getUsername().contains("admin")){
        throw new NegocioException("Username ou Password inválido");
        }
    }
    
    

    @Override
    public void inserir(Usuario entidade) throws NegocioException {
    }

    @Override
    public void alterar(Usuario entidade) throws NegocioException {
    }

    @Override
    public void excluir(Usuario entidade) throws NegocioException {
    }

    @Override
    public Usuario consultar(int id) throws NegocioException {
        return new Usuario();
    }

    @Override
    public List<Usuario> listar() throws NegocioException {
        return new ArrayList<Usuario>();
    }
    
    public void autenticar(Usuario entidade) throws NegocioException {
       validar(entidade);
    }

}
