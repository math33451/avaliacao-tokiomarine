<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <li>
    <p>Conta Origem</p>
    <input type="text" name="contaOrigem" size="30" /> 
    </li>
    <li>
    <p>Conta Destino</p>
    <input type="text" name="contaDestino" size="30" /> 
    </li>
    <li>
    <p>Valor</p>
    <input type="text" name="valor" size="30" /> 
    </li>
    <li>
    <p>Dia da Transferência</p>
    <input type="text" name="dataTransferência" size="30" /> 
    </li>
    <li>
    <p>Dia de Hoje</p>
    <input type="text" name="dataAgendada" size="30" /> 
    </li>
    <li>
    <p>Tipo de Operação (1, 2, 3 ou 4)</p>
    <input type="text" name="dataAgendada" size="30" /> 
    </li>
    <div>
      <input type="submit" value="Transferir">
    </div>
    <div>
      <input type="submit" value="Listar Transferências">
    </div>
    <h3>Instruções:</h3>
    <div>Informe a conta de origem e a conta de destino.</div>
    <div>Informe o valor a ser enviado.</div>
    <div>Informe a data para a transferência ser realizada (dia de hoje + dias até a data da transferência, ex: 36)</div>
    <div>Selecione o tipo de operação, sendo:</div>
    <ul>
    <div2><p>1- Operações tipo A:</p> são as agendadas para hoje.</div2>
    <div2><p>2- Operações tipo B:</p> são as agendadas para até 10 dias.</div2>
    <div2><p>3- Operações tipo C:</p> são as agendadas para após 10 dias.</div2>
    <div3><p>4- Operações tipo D:</p> são as taxadas de acordo com seu valor.</div3>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  padding: 10px;
  border: 2px solid black;
  display: flex;
}
li {
  display: inline-block;
  margin: 0 10px;
  border-left: 1.5px solid black;
  border-right: 1.5px solid black;
}
a {
  color: #42b983;
}
div{
  margin: 10px;
}

div2{
  margin: 10px;
  border-left: 2px solid white;
}

div3{
  margin: 10px;
  padding: 10px;
  border-right: 2px solid white;
  border-left: 2px solid white;
}
</style>
