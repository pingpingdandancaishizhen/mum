import Layout from './layout.vue';
import Tablefile from './tableFile.vue';
import InputText from './inputText.vue';//input text组件
import Option from './option.vue';//select组件
import Option2 from './option2.vue';//需要单独请求数据的select组件
import Radio from './radio.vue';//单选框组件
import Checkbox from './checkbox.vue';//checkbox
import singleCheckbox from './single-checkbox.vue';//单选checkbox
import FileUpload from './fileUpload.vue';//单文件上传组件
import MultiFileUpload from './multiFileUpload.vue';//多文件上传组件
import Address from './address.vue';//省市县组件
import DataTime from './dataTime.vue';//时间组件
import Car300 from './car300.vue';//车系列
import GenButton from './genButton.vue';//获取合同号按钮
import Job from './job.vue';//职业
import Heightexamine from './heightExamine.vue';//高审组件
import applyExamine from './applyExamine.vue';//请求申请还款方式
import contract from './contract.vue';//合同
import account from './account.vue';//账号类型
import IDAccount from './IDAccount.vue';//账号类型
import p2pLoanApply from './p2p-loan-apply.vue';//p2p借款信息
import relation from './relation_table.vue';//紧急联系人
import credit from './credit_table.vue';//征信

export default {
  'app-layout':Layout,
  'app-table-file':Tablefile,
  'app-text':InputText,
  'app-option':Option,
  'app-option2':Option2,
  'app-radio':Radio,
  'app-checkbox':Checkbox,
  'app-single-checkbox':singleCheckbox,
  'app-file-upload':FileUpload,
  'app-multi-file-upload':MultiFileUpload,
  'app-address':Address,
  'app-date':DataTime,
  'app-car300':Car300,
  'app-gen-button':GenButton,
  'app-job':Job,
  'app-height-examine':Heightexamine,
  'app-apply-examine':applyExamine,
  'app-contract':contract,
  'app-account':account,
  'app-ID-account':IDAccount,
  'app-p2p-loan-apply':p2pLoanApply,
  'app-relation':relation,
  'app-credit':credit,
}

