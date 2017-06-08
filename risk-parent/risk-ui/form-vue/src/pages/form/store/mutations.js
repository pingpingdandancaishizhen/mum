/**
 * Created by RJS on 2017/1/3.
 */
import { set } from 'vue'
import * as types from './mutation-types';
export default {
  [types.RECEIVE_ALL](state,data){
    state.receiveData=data
  },
  [types.RECEIVE_ADDRESS_DATA](state,data){
    state.addressData=data;
  },
  [types.RECEIVE_CAR300_DATA](state,data){
    state.car300Data=data;
  }
  ,
  [types.EXAMINE_DATA](state,data){
    state.examineData=data;
  },
  [types.LOAN_DATA](state,data){
    state.loanData=data;
  }
  ,
  [types.LOAN_FEE_DATA](state,data){
    state.loanFeeData=data;
  }
  ,
  [types.CONTRACT_DATA](state,data){
    state.contractData=data;
  },
  [types.SHOW](state,args){
    var oldShowLoad=state.showLoad
    state.showLoad=Object.assign({},oldShowLoad,args)
  },
  [types.ERROR](state,data){
    let oldErrorMsg=state.errorMsg;
    state.errorMsg=Object.assign({},oldErrorMsg,data)
  },
  [types.CREDITS_DATA](state,data){
    state.creditsData=data;
  }
}
