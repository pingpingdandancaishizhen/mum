/**
 * Created by RJS on 2017/1/3.
 */
import * as types from '../mutation-types';
const state={
  layOutData:[],
  tableFileUpData:{},
  show:false,
};
const getters={
  layOutData:state=>state.layOutData,
  tableFileUpData:state=>state.tableFileUpData,
};
const actions={
};
const mutations={
  [types.LAYOUT_DATA](state,{index,data}){
    state.layOutData[index]=data
  },
  [types.TABLE_FILE_UP_DATA](state,{key,data}){
    state.tableFileUpData[key]=data
  },
};
export default {
  state,
  getters,
  actions,
  mutations
}
