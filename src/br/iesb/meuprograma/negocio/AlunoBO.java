package br.iesb.meuprograma.negocio;

import br.iesb.meuprograma.dados.Aluno;
import br.iesb.meuprograma.dados.AlunoDAO;
import br.iesb.meuprograma.dados.DadosException;
import java.util.ArrayList;
import java.util.List;

public class AlunoBO implements BO<Aluno> {

    @Override
    public void validar(Aluno entidade) throws NegocioException {
        if (entidade.getNome().isEmpty()) {
            throw new NegocioException("O campo nome é obrigatório");
        }
        if (entidade.getDataNascimento().isEmpty()) {
            throw new NegocioException("O campo data de nascimento é obrigatório");
        }
    }

    @Override
    public void inserir(Aluno entidade) throws NegocioException {
        validar(entidade);
        AlunoDAO dao = new AlunoDAO();
        try {
            dao.inserir(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("", ex);
        }
    }

    @Override
    public void alterar(Aluno entidade) throws NegocioException {
        consultar(entidade.getId());
        validar(entidade);
        AlunoDAO dao = new AlunoDAO();
        try {
            dao.alterar(entidade);
        } catch (DadosException ex) {
            throw new NegocioException("", ex);
        }

    }

    @Override
    public void excluir(Aluno entidade) throws NegocioException {

    }

    @Override
    public Aluno consultar(int id) throws NegocioException {
        Aluno aluno = new Aluno();
        AlunoDAO dao = new AlunoDAO();
        try {
            aluno = dao.consultar(id);
            if (aluno.getId() == 0) {
                throw new NegocioException("Aluno não encontrado");
            }

        } catch (DadosException ex) {
            throw new NegocioException("", ex);
        }
        return aluno;
    }
        @Override
        public List<Aluno> listar() throws NegocioException {
            List<Aluno> lista = new ArrayList<Aluno>();
            AlunoDAO dao = new AlunoDAO();
            try {
                lista = dao.listar();
                if (lista.isEmpty()) {
                    throw new NegocioException("Nenhum aluno cadastrado");
                }
            } catch (DadosException ex) {
                throw new NegocioException("", ex);
            }
            return lista;
        }
    }
