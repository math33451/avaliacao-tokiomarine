<template>
  <html lang="pt-br">
    <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Sistema de Transferências</title>
  </head>
  <body>
    <div class="bg-success">
    <h1 class="text-center">Sistema de Transferências</h1>
    </div>

    <form @submit.prevent="salvar">
  <div class="form-group row">
    <label for="input" class="col-sm-2 col-form-label">Conta de Origem</label>
    <div class="col-sm-10">
      <input type="conta" class="form-control" id="input" placeholder="Conta de Origem" maxlength="6" v-model="transferencia.contaOrigem">
    </div>
  </div>
  <div class="form-group row">
    <label for="input" class="col-sm-2 col-form-label">Conta de Destino</label>
    <div class="col-sm-10">
      <input type="conta" class="form-control" id="input" placeholder="Conta de Destino" maxlength="6" v-model="transferencia.contaDestino">
    </div>
  </div>
  <div class="form-group row">
    <label for="input" class="col-sm-2 col-form-label">Valor</label>
    <div class="col-sm-10">
      <input type="conta" class="form-control" id="input" placeholder="Valor" v-model="transferencia.valor">
    </div>
  </div>
  <div class="form-group row">
    <label for="input" class="col-sm-2 col-form-label">Data da Transferência</label>
    <div class="col-sm-10">
      <input type="conta" class="form-control" id="input" placeholder="Inserir o dia de hoje + para daqui quantos dias será a transfêrencia. Ex: 35" v-model="transferencia.dataTransferencia">
    </div>
  </div>
    <div class="form-group row">
    <label for="input" class="col-sm-2 col-form-label">Data de Hoje</label>
    <div class="col-sm-10">
      <input type="conta" class="form-control" id="input" placeholder="Número do dia" v-model="transferencia.dataAgendada">
    </div>
  </div>
    <div class="form-group">
    <label for="exampleFormControlSelect1">Tipo de Operação</label>
    <div class="col-sm-3">
    <select class="form-control" id="exampleFormControlSelect1" v-model="transferencia.tipoOperacao">
      <option>A (Transferências para hoje)</option>
      <option>B (Transferências para até 10 dias)</option>
      <option>C (Transferências para depois de 10 dias)</option>
      <option>D (Taxar pelo valor)</option>
    </select>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary">Salvar</button>
    </div>
  </div>
</form>

<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Origem</th>
      <th scope="col">Destino</th>
      <th scope="col">Valor</th>
      <th scope="col">Taxa</th>
      <th scope="col">Data Agendada</th>
      <th scope="col">Data da Transferencia</th>
      <th scope="col">Tipo de Operação</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="transferencia of transferencias" :key="transferencia.id">
      <th scope="row">{{ transferencia.id }}</th>
      <td>{{ transferencia.contaOrigem }}</td>
      <td>{{ transferencia.contaDestino }}</td>
      <td>{{ transferencia.valor }}</td>
      <td>{{ transferencia.taxa }}</td>
      <td>{{ transferencia.dataAgendada }}</td>
      <td>{{ transferencia.dataTransferencia }}</td>
      <td>{{ transferencia.tipoOperacao }}</td>
    </tr>
  </tbody>
</table>
  </body>
</html>
</template>

<script>
    import Transferencia from '/src/services/transferencias'

    export default {
          name: 'MyHome',
          data(){
    return{
      transferencia: {

        contaOrigem: '',
        contaDestino: '',
        valor: '',
        taxa: '',
        dataAgendada: '',
        dataTransferencia: '',
        tipoOperacao:''
      },
      transferencias: []
    }
  },

  mounted(){
    this.listar()
  },

  methods:{
    
    listar(){
      Transferencia.listar().then(resposta => {
        this.transferencias = resposta.data
    })
    },

    salvar(){

     Transferencia.salvar(this.transferencia).then(resposta => {
       this.transferencia = {}
       alert('Transferencia salva com sucesso!')
       this.listar(resposta)
     }).catch( e => {
       console.log(e.response.data.error)
       alert('ERRO! Verifique os campos e tente novamente \n Operações tipo A precisam ser realizadas no dia de hoje. \n Operações tipo B precisam ser em até 10 dias. \n Operações tipo C precisam ser após 10 dias. \n Operações tipo D são para optar pelas taxas de acordo com o valor.')
       this.transferencia = {}
       
     })

    }

  }
    }


</script>