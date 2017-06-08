/**
 * Created by RJS on 2017/1/3.
 */
import Vue from 'vue'
import Vuex from 'vuex'
import actions from './actions';
import mutations from './mutations';
import getters from './getters'
// import layout from './modules/layout'
import modules from './modules'
Vue.use(Vuex);
var state={
    receiveData:{},
    addressData:'',
    car300Data:'',
    examineData:'',
    loanData:'',
    contractData:'',
    submitData:{},
    showLoad:{},
    errorMsg:{},
    creditsData:{}
};
export default new Vuex.Store({
  state,
  actions,
  mutations,
  getters,
  modules: modules
})
