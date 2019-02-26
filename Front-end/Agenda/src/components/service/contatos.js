import {http} from "./config";
export default {
  getContatos:()=>{
    return http.get('/')
  },
  createContato:(contato)=>{
    return http.post('/cadastrar', contato)

  },
  updateContato:(contato)=>{
    return http.put('/atualizar', contato)
  },
  deleteContato:(contato)=>{
    return http.delete('/deletar', {data:contato})

  }
}
