/**
 * Created by RJS on 2017/1/3.
 */
import * as api from '../api';
import * as types from './mutation-types'
export default {
  //获取表单数据
  getAllFormData({commit},opts){
    api.getFormData(opts, data=> {
      commit(types.RECEIVE_ALL, data)
    })
  },
  //获取高审数据
  getExamineData({commit},opts){
    api.getExamineData(opts,data=>{
      commit(types.EXAMINE_DATA,data)
    })
  },
  //获取p2p借款信息
  getLoanData({commit},opts){
    api.getLoanData(opts,data=>{
      commit(types.LOAN_DATA,data)
    })
  },
  getFeeData({commit},opts){
    api.getFeeData(opts,data=>{
      commit(types.LOAN_FEE_DATA,data)
    })
  },
  //获取合同数据
  getContractData({commit},opts){
    api.getExamineData(opts,data=>{
      commit(types.CONTRACT_DATA,data)
    })
  },
  //是否显示load
  showLoad({commit},args){
    // console.log('commit',args)
    commit(types.SHOW,args)
  },
  //设置错误信息
  setError({commit},args){
    commit(types.ERROR,args)
  },
  //获取征信数据
  getCreditsData({commit},opts){
    api.getCreditsData(opts,data=>{
      commit(types.CREDITS_DATA,data)
    })
  },
};

