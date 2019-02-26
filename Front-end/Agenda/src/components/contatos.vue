<template>
<div>
  <nav>
    <div class="nav-wrapper container">
      <a href="#" class="brand-logo center">Agenda</a>
    </div>
  </nav>

  <div class="container">
    <div class="row"></div>
    <form @submit.prevent="saveContato">

      <input type="hidden" />

      Nome <input v-model="contato.nome" type="text"/><br/>
      Email <input  v-model="contato.email" type="email"/> <br/>
      Telefone <input v-model="contato.telefone" type="number"/><br/>

      <button  class="btn waves-effect waves-light" type="submit" >salvar
        <i class="material-icons right">save</i></button>
    </form>

    <div class="row"></div>
    <table>
      <thead>
      <tr>
        <th>Nome</th>
        <th>Email</th>
        <th>Telefone</th>
        <th>Editar</th>
        <th>Deletar</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="contato of contatos" :key="contato.id">
        <td>{{contato.nome}}</td>
        <td>{{contato.email}}</td>
        <td>{{contato.telefone}}</td>
        <td><button @click="updateContato(contato)" class="btn btn-flat"><i class="material-icons">edit</i></button></td>
        <td><button @click="deleteContato(contato)" class="btn btn-flat"><i class="material-icons">delete</i></button></td>
      </tr>
      </tbody>
    </table>
  </div>
</div>

</template>

<script>
  import Contato from './service/contatos'
export default {
    data(){
      return{
        contatos:[],
        contato:{
          id:'',
          nome:'',
          email:'',
          telefone:''
        },
      }
    },
  mounted() {
      this.getContatos()
  },
  methods:{
      getContatos(){
        Contato.getContatos().then(response=>{
          this.contatos = response.data;
        })
      },
    saveContato(){
        if(!this.contato.id) {
          if(this.contato.nome!='' && this.contato.telefone!='' && this.contato.email!=''){
            Contato.createContato(this.contato).then(response => {
              this.contato = {};
              alert("contato salvo com sucesso");
              this.getContatos();
            })
          }else{
            alert("nenhum campo pode ficar vazio")
          }
        }else {
          Contato.updateContato(this.contato).then(response => {
            this.contato = {};
            alert("contato atualizado com sucesso");
            this.getContatos()
          })
        }
    },
    updateContato(contato){
       // this.contato.id = contato.id;
        //this.contato.nome=contato.nome;
       // this.contato.email=contato.email;
       // this.contato.telefone=contato.telefone;
        this.contato=contato
    },
    deleteContato(contato){
        Contato.deleteContato(contato).then(response=>{
          this.getContatos();
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>

</style>
