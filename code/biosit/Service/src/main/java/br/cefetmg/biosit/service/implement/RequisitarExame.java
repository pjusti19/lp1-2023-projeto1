//package br.cefetmg.biosit.service.implement;
//
//import br.cefetmg.biosit.DAOMySQL.ExameDAO;
//import br.cefetmg.biosit.dto.Exame;
//import br.cefetmg.biosit.dto.exception.CadastroException;
//import br.cefetmg.biosit.dto.exception.ExameDuplicadoException;
//import br.cefetmg.biosit.idao.IExameDAO;
//import br.cefetmg.biosit.service.util.Util;
//import java.util.List;
//import java.util.ArrayList;
//
///**
// *
// * @author Aluno
// */
//public class RequisitarExame implements IExameDAO{
//        private IExameDAO exameDAO;
//
//        public RequisitarExame() {
//            exameDAO = new ExameDAO();
//        }
//      public String cadastrar(Exame exame) throws CadastroException, ExameDuplicadoException {
//        
//        if(Util.verify(exame.getPaciente())) {
//            throw new CadastroException("Cadastro Incompleto, insira um nome");
//        }
//        if(Util.verify(exame.getDataHora())) {
//            throw new CadastroException("Cadastro Incompleto, insira uma data e hora");
//        }
//        if(Util.verify(exame.getExame())) {
//            throw new CadastroException("Cadastro Incompleto, insira um exame");
//        }
//        
//        if(exame.getPaciente().length() > 50) {
//            throw new CadastroException("O nome não pode ter mais de 50 caracteres");
//        }
//        
//        
//        exameDAO.inserir(exame);
//        
//        return "";
//    }
//    
//    @Override
//    public String atualizar(Exame exame) throws Exception {
//        String id = "";
//        if(Util.verify(exame.getPaciente())) {
//            throw new CadastroException("Cadastro Incompleto, insira um nome");
//        }
//        if(Util.verify(exame.getDataHora())) {
//            throw new CadastroException("Cadastro Incompleto, insira uma data e hora");
//        }
//        if(Util.verify(exame.getExame())) {
//            throw new CadastroException("Cadastro Incompleto, insira uma data de nascimento");
//        }
//        
//        System.out.println(exame);
//        exameDAO.atualizar(exame);
//        
//        return null;
//    }
//    @Override
//    public String excluir(Exame exame) throws Exception {
//        String id = "";
//        
//        if(Util.verify(exame)) 
//            throw new CadastroException("Erro");
//        
//        exameDAO.deletar(exame);
//        
//        return id;
//    }
//    
//     public List<Exame> pesquisar(Exame exame) throws Exception {
//        List<Exame> pacientes = new ArrayList<Exame>();
//        if(Util.verify(exame)) {
//            exames = exameDAO.pesquisarTodos();
//        } else {
//            if(!Util.verify(exame.getPaciente())) {
//                pacientes.addAll(exameDAO.pesquisarPaciente(exame.getPaciente()));
//            }
//            if(!Util.verify(exame.getDataHora())) {
//                List<Exame> novos = exameDAO.pesquisarDataHora(exame.getDataHora());
//                for(Exame novo : novos) {
//                    boolean ver = true;
//                    for(Exame exist : pacientes) {
//                        if(exist.equals(novo)) ver = false;
//                    }
//                    if(ver) pacientes.add(novo);
//                }
//            }
//            if(!Util.verify(exame.getExame())) {
//                List<Exame> novos = exameDAO.pesquisarExame(exame.getExame());
//                for(Exame novo : novos) {
//                    System.out.println(novo);
//                    boolean ver = true;
//                    for(Exame exist : exames) {
//                        if(exist.equals(novo)) ver = false;
//                    }
//                    if(ver) exames.add(novo);
//                }
//            }
//        }
//        return exames;
//    }
//    
//    public Exame pesquisar(String cpf) throws Exception {
//        Exame exame = null;
//        exame = exameDAO.pesquisarCPF(cpf);
//        
//        return exame;
//    }
//}
