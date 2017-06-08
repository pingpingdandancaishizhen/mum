/**
 * Created by RJS on 2017/1/3.
 */
import * as types from '../mutation-types';
const state={
};
const actions={
  setInputData:function ({rootState,commit}, data) {
      commit(types.SET_SUBMIT_DATA,{rootState,data})
  },
  delInputData:function ({rootState,commit}, key) {
    commit(types.DEL_SUBMIT_DATA,{rootState,key})
  },
  setAddress:function ({rootState, commit}, data) {
    commit(types.ADDRESS_DATA,{rootState,data})
  },
  setTimeDate:function ({rootState, commit}, data) {
    commit(types.DATE_TIME_DATA,{rootState,data})
  },
};
const mutations={
  [types.SET_SUBMIT_DATA](state,{rootState,data}){
    for(let key in data){
      var value=data[key];
      if(typeof(value)!=='undefined'){
        value=value.toString().trim();
      }
      rootState.submitData[key]=value
    }
  },
  [types.DEL_SUBMIT_DATA](state,{rootState,key}){
    var keyType=typeof key
    if(keyType.toLocaleLowerCase()==='string'){
      if(rootState.submitData.hasOwnProperty(key)){
        delete rootState.submitData[key]
      }
    }
    if(keyType.toLocaleLowerCase()==='object'){
      for(var i in key){
        var item=key[i];
        if(rootState.submitData.hasOwnProperty(item)){
          delete rootState.submitData[item]
        }
      }
    }
  },
  [types.ADDRESS_DATA](state,{rootState,data}){
    var key=data.key;//省/市/县
    var value=data.value;
    var position=value.position||'';
    var positionArr=position.split('/');
    var detailAddress=value.detailAddress||'';
    var bindkeyArr=key?key.split(','):[];
    var detailkey=bindkeyArr.pop();
    bindkeyArr.forEach(function (v, k) {
      var value=positionArr[k];
      rootState.submitData[v]=value;
    });
    rootState.submitData[detailkey]=detailAddress;
  },
  [types.DATE_TIME_DATA](state,{rootState,data}){
    rootState.submitData[data.key]=data.value
  }
};
export default {
  state,
  actions,
  mutations
}
