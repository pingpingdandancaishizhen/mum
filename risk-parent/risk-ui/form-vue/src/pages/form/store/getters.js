/**
 * Created by RJS on 2017/1/3.
 */
export default {
  optionData: state=>state.receiveData.optionData || {},
  attrsData: state=>state.receiveData.attrsData || {},
  defaultHiddenData: state=>state.receiveData.defaultHiddenData || {},
  buttonData: state=>state.receiveData.buttonData ,
  operationsData: state=>state.receiveData.operationsData || {},
  rulesData:state=>state.receiveData.rulesData||{},
  formData: state=> {
    var layoutInfo = state.receiveData.layoutInfo || {};
    if (layoutInfo) {
      return layoutInfo.groups||{}
    }
  },
  addressData: state=>state.addressData||{},
  car300Data: state=>state.car300Data||{},
  examineData: state=>state.examineData||{},
  loanData: state=>state.loanData||{},
  loanFeeData: state=>state.loanFeeData||{},
  view:state=>state.receiveData.view,
  showLoad:state=>state.showLoad||{},
  errorMsg:state=>state.errorMsg||{},
  creditsData:state=>state.creditsData||{},
}

