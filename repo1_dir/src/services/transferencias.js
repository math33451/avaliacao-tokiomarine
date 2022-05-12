import {http} from './config'

export default {

    listar:() => {
        return http.get('transferencias')
    },

    salvar:(transferencia) => {
        return http.post('transferencia', transferencia)
    }
}