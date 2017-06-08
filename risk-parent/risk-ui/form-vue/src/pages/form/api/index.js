/**
 * Created by RJS on 2017/1/3.
 */
import Vue from 'vue'
/*import VueResource from 'vue-resource';
 Vue.use(VueResource);*/
// 获取表单格式
export function getFormData(opts, cb) {
  var queryView = tools.queryString('view');

/*
  //todo 测试
  var testdata = {
    "status" : 1,
    "message" : "成功",
    "data" : {
      "layoutInfo" : {
        "key" : null,
        "label" : null,
        "layout" : "form",
        "groups" : [
          {
          "tabList" : [ {
            "label" : "客户基本信息",
            "key" : "cust",
            "layout" : "form",
            "editors" : [
              {
                "key" : "cust_type",
                "label" : "客户类型",
                "editor" : "credit",
                "rows" : 1,
                "cols" : 1,
                "readonly" : false,
                "binding" : null,
                "category" : "客户基本信息",
                "visible" : null,
                "unit" : null,
                "required" : true,
                "extEditors" : null,
                "extGroups" : null,
                "param" : null
              }
            ],
            "cols" : null,
            "rows" : null
          },
          ],
          "tabName" : "客户信息",
          "handle" : true
        },
          ],
        "rules" : null,
        "relations" : null,
        "buttons" : [ {
          "key" : "save",
          "name" : "保存草稿",
          "url" : "/loan/saveDraft",
          "method" : "post",
          "close" : true,
          "validate" : false
        }, {
          "key" : "saveDraft",
          "name" : "保存",
          "url" : "/loan/saveDraft",
          "method" : "post",
          "close" : true,
          "validate" : true
        }, {
          "key" : "submit",
          "name" : "提交",
          "url" : "/loan/submit",
          "method" : "post",
          "close" : true,
          "validate" : true
        } ],
        "html" : null
      },
      "attrs" : {
        "loancar_registration_date" : {
          "attrName" : "loancar_registration_date",
          "attrValue" : "",
          "draftValue" : null
        },
        "loansecurity_desc4" : {
          "attrName" : "loansecurity_desc4",
          "attrValue" : null,
          "draftValue" : null
        },
        "custjob_reg_date" : {
          "attrName" : "custjob_reg_date",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanrebank_bank" : {
          "attrName" : "loanrebank_bank",
          "attrValue" : null,
          "draftValue" : null
        },
        "loansecurity_desc2" : {
          "attrName" : "loansecurity_desc2",
          "attrValue" : null,
          "draftValue" : null
        },
        "loansecurity_desc3" : {
          "attrName" : "loansecurity_desc3",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_regist_addr_detail" : {
          "attrName" : "cust_regist_addr_detail",
          "attrValue" : "123",
          "draftValue" : null
        },
        "loansecurity_desc1" : {
          "attrName" : "loansecurity_desc1",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarassess_price" : {
          "attrName" : "loancarassess_price",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarimg_vehicle_registration" : {
          "attrName" : "loancarimg_vehicle_registration",
          "attrValue" : "",
          "draftValue" : null
        },
        "cust_marriage" : {
          "attrName" : "cust_marriage",
          "attrValue" : "1",
          "draftValue" : null
        },
        "loancheckph_phone1" : {
          "attrName" : "loancheckph_phone1",
          "attrValue" : null,
          "draftValue" : null
        },
        "custjob_turnover_month" : {
          "attrName" : "custjob_turnover_month",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarimg_instrument_panel" : {
          "attrName" : "loancarimg_instrument_panel",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancheckph_phone2" : {
          "attrName" : "loancheckph_phone2",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanassethimg_mortgage_contract" : {
          "attrName" : "loanassethimg_mortgage_contract",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower3_license_num" : {
          "attrName" : "borrower3_license_num",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancheckph_friends" : {
          "attrName" : "loancheckph_friends",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarimg_copilot_drive_glass" : {
          "attrName" : "loancarimg_copilot_drive_glass",
          "attrValue" : "",
          "draftValue" : null
        },
        "loanbank_addr_province" : {
          "attrName" : "loanbank_addr_province",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancontractimg_gps" : {
          "attrName" : "loancontractimg_gps",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancheckph_telephone" : {
          "attrName" : "loancheckph_telephone",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancheckph_technical_title" : {
          "attrName" : "loancheckph_technical_title",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarimg_car_owner" : {
          "attrName" : "loancarimg_car_owner",
          "attrValue" : "",
          "draftValue" : null
        },
        "custjob_industry" : {
          "attrName" : "custjob_industry",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_email" : {
          "attrName" : "cust_email",
          "attrValue" : "12@q.c",
          "draftValue" : null
        },
        "loancarimg_main_drive_glass" : {
          "attrName" : "loancarimg_main_drive_glass",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancar_engine_number" : {
          "attrName" : "loancar_engine_number",
          "attrValue" : "",
          "draftValue" : null
        },
        "custjob_company_addr_city" : {
          "attrName" : "custjob_company_addr_city",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanasseth_purchase_date" : {
          "attrName" : "loanasseth_purchase_date",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanadvice_eachTimes" : {
          "attrName" : "loanadvice_eachTimes",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarimg_other" : {
          "attrName" : "loancarimg_other",
          "attrValue" : "",
          "draftValue" : null
        },
        "cust_phone" : {
          "attrName" : "cust_phone",
          "attrValue" : "6453233",
          "draftValue" : null
        },
        "borrower2_name" : {
          "attrName" : "borrower2_name",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanbank_account_no" : {
          "attrName" : "loanbank_account_no",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_qq" : {
          "attrName" : "cust_qq",
          "attrValue" : "1232132",
          "draftValue" : null
        },
        "borrower2_home_addr_counties" : {
          "attrName" : "borrower2_home_addr_counties",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_license_num" : {
          "attrName" : "cust_license_num",
          "attrValue" : "150723198403216714",
          "draftValue" : null
        },
        "loancar_car_bms" : {
          "attrName" : "loancar_car_bms",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_c7" : {
          "attrName" : "loancarrepair_mal_c7",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_c6" : {
          "attrName" : "loancarrepair_mal_c6",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanapproval_monthlyZHFee" : {
          "attrName" : "loanapproval_monthlyZHFee",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower3_mobile" : {
          "attrName" : "borrower3_mobile",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanasseth_address_detail" : {
          "attrName" : "loanasseth_address_detail",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanapproval_supportFirstPay" : {
          "attrName" : "loanapproval_supportFirstPay",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancar_registration_model" : {
          "attrName" : "loancar_registration_model",
          "attrValue" : "",
          "draftValue" : null
        },
        "loanapproval_bzjFee" : {
          "attrName" : "loanapproval_bzjFee",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanadvice_need" : {
          "attrName" : "loanadvice_need",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_c1" : {
          "attrName" : "loancarrepair_mal_c1",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanassethimg_owner_certificate" : {
          "attrName" : "loanassethimg_owner_certificate",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanasseth_has" : {
          "attrName" : "loanasseth_has",
          "attrValue" : "",
          "draftValue" : null
        },
        "custjob_company_addr_detail" : {
          "attrName" : "custjob_company_addr_detail",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_c3" : {
          "attrName" : "loancarrepair_mal_c3",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_c2" : {
          "attrName" : "loancarrepair_mal_c2",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_c5" : {
          "attrName" : "loancarrepair_mal_c5",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanapproval_daylyRate" : {
          "attrName" : "loanapproval_daylyRate",
          "attrValue" : null,
          "draftValue" : null
        },
        "custjob_company_addr_province" : {
          "attrName" : "custjob_company_addr_province",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_c4" : {
          "attrName" : "loancarrepair_mal_c4",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_p7" : {
          "attrName" : "loancarrepair_mal_p7",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanbank_account_name" : {
          "attrName" : "loanbank_account_name",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_friend_know" : {
          "attrName" : "custfriend_friend_know",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarinfo_keys" : {
          "attrName" : "loancarinfo_keys",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_p3" : {
          "attrName" : "loancarrepair_mal_p3",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_idcard_ver" : {
          "attrName" : "cust_idcard_ver",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_p4" : {
          "attrName" : "loancarrepair_mal_p4",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower3_role" : {
          "attrName" : "borrower3_role",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_p5" : {
          "attrName" : "loancarrepair_mal_p5",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancar_approved_passenger" : {
          "attrName" : "loancar_approved_passenger",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarrepair_mal_p6" : {
          "attrName" : "loancarrepair_mal_p6",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarassessimg_group_photo" : {
          "attrName" : "loancarassessimg_group_photo",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_p1" : {
          "attrName" : "loancarrepair_mal_p1",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarimg_insurance_policy" : {
          "attrName" : "loancarimg_insurance_policy",
          "attrValue" : "",
          "draftValue" : null
        },
        "borrower2_relation" : {
          "attrName" : "borrower2_relation",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower3_corp_name" : {
          "attrName" : "borrower3_corp_name",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_p2" : {
          "attrName" : "loancarrepair_mal_p2",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend" : {
          "attrName" : "custfriend",
          "attrValue" : null,
          "draftValue" : null
        },
        "custearn_bank_bill" : {
          "attrName" : "custearn_bank_bill",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanbank_branch" : {
          "attrName" : "loanbank_branch",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanapproval_monthlyGLFee" : {
          "attrName" : "loanapproval_monthlyGLFee",
          "attrValue" : null,
          "draftValue" : null
        },
        "loan_usage" : {
          "attrName" : "loan_usage",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarimg_drive_license" : {
          "attrName" : "loancarimg_drive_license",
          "attrValue" : "",
          "draftValue" : null
        },
        "loanofee_gpsservice_pay" : {
          "attrName" : "loanofee_gpsservice_pay",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancontractimg_service" : {
          "attrName" : "loancontractimg_service",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_company_name" : {
          "attrName" : "custfriend_company_name",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanofee_park_pay" : {
          "attrName" : "loanofee_park_pay",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanasseth_address_city" : {
          "attrName" : "loanasseth_address_city",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancontractimg_attorney" : {
          "attrName" : "loancontractimg_attorney",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_friend_company_name" : {
          "attrName" : "custfriend_friend_company_name",
          "attrValue" : null,
          "draftValue" : null
        },
        "loan_apply_repaymentTypes" : {
          "attrName" : "loan_apply_repaymentTypes",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarimg_wheel_left" : {
          "attrName" : "loancarimg_wheel_left",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarinfo_use_nature" : {
          "attrName" : "loancarinfo_use_nature",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancheckinfo_data" : {
          "attrName" : "loancheckinfo_data",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanassethimg_purchase_contract" : {
          "attrName" : "loanassethimg_purchase_contract",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_company_name_4" : {
          "attrName" : "custfriend_company_name_4",
          "attrValue" : "",
          "draftValue" : null
        },
        "custfriend_spouse_name" : {
          "attrName" : "custfriend_spouse_name",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower3_relation" : {
          "attrName" : "borrower3_relation",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_come_time" : {
          "attrName" : "cust_come_time",
          "attrValue" : "2017-05-22",
          "draftValue" : null
        },
        "loan_apply_eachTimes" : {
          "attrName" : "loan_apply_eachTimes",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancar_yearcount" : {
          "attrName" : "loancar_yearcount",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_info_b" : {
          "attrName" : "loancarrepair_info_b",
          "attrValue" : null,
          "draftValue" : null
        },
        "custimg_idcard1" : {
          "attrName" : "custimg_idcard1",
          "attrValue" : "0ef6a69168dd40828c2859304da3e102",
          "draftValue" : null
        },
        "cust_gender" : {
          "attrName" : "cust_gender",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarinfo_detail_config_other" : {
          "attrName" : "loancarinfo_detail_config_other",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_company_name_1" : {
          "attrName" : "custfriend_company_name_1",
          "attrValue" : "",
          "draftValue" : null
        },
        "custfriend_company_name_0" : {
          "attrName" : "custfriend_company_name_0",
          "attrValue" : "3231",
          "draftValue" : null
        },
        "custimg_idcard2" : {
          "attrName" : "custimg_idcard2",
          "attrValue" : "b44d94980eaa4c12a8329b63f31c2f74",
          "draftValue" : null
        },
        "custfriend_company_name_3" : {
          "attrName" : "custfriend_company_name_3",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarrepair_accident" : {
          "attrName" : "loancarrepair_accident",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_company_name_2" : {
          "attrName" : "custfriend_company_name_2",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancontractimg_r_mortgage" : {
          "attrName" : "loancontractimg_r_mortgage",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancar_car_fuel" : {
          "attrName" : "loancar_car_fuel",
          "attrValue" : "",
          "draftValue" : null
        },
        "custjob_company_name" : {
          "attrName" : "custjob_company_name",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower3_home_addr_province" : {
          "attrName" : "borrower3_home_addr_province",
          "attrValue" : null,
          "draftValue" : null
        },
        "loansecurity_id1" : {
          "attrName" : "loansecurity_id1",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarinfo_detail_config" : {
          "attrName" : "loancarinfo_detail_config",
          "attrValue" : null,
          "draftValue" : null
        },
        "loan_apply" : {
          "attrName" : "loan_apply",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanapproval_eachTimes" : {
          "attrName" : "loanapproval_eachTimes",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancar_year_num" : {
          "attrName" : "loancar_year_num",
          "attrValue" : "",
          "draftValue" : null
        },
        "loanasseth_type" : {
          "attrName" : "loanasseth_type",
          "attrValue" : null,
          "draftValue" : null
        },
        "loan_apply_monthlyTerm" : {
          "attrName" : "loan_apply_monthlyTerm",
          "attrValue" : "",
          "draftValue" : null
        },
        "loanrebank_account_name" : {
          "attrName" : "loanrebank_account_name",
          "attrValue" : null,
          "draftValue" : null
        },
        "loansecurity_status2" : {
          "attrName" : "loansecurity_status2",
          "attrValue" : null,
          "draftValue" : null
        },
        "loansecurity_id4" : {
          "attrName" : "loansecurity_id4",
          "attrValue" : null,
          "draftValue" : null
        },
        "loansecurity_status1" : {
          "attrName" : "loansecurity_status1",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancheckinfo_car" : {
          "attrName" : "loancheckinfo_car",
          "attrValue" : null,
          "draftValue" : null
        },
        "loansecurity_status4" : {
          "attrName" : "loansecurity_status4",
          "attrValue" : null,
          "draftValue" : null
        },
        "loansecurity_id2" : {
          "attrName" : "loansecurity_id2",
          "attrValue" : null,
          "draftValue" : null
        },
        "loansecurity_status3" : {
          "attrName" : "loansecurity_status3",
          "attrValue" : null,
          "draftValue" : null
        },
        "loansecurity_id3" : {
          "attrName" : "loansecurity_id3",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_relation_0" : {
          "attrName" : "custfriend_relation_0",
          "attrValue" : "11",
          "draftValue" : null
        },
        "loanapproval_monthlyRate" : {
          "attrName" : "loanapproval_monthlyRate",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower2_corp_phone" : {
          "attrName" : "borrower2_corp_phone",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_relation_4" : {
          "attrName" : "custfriend_relation_4",
          "attrValue" : "",
          "draftValue" : null
        },
        "custfriend_relation_3" : {
          "attrName" : "custfriend_relation_3",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancar_car_bms_model" : {
          "attrName" : "loancar_car_bms_model",
          "attrValue" : "",
          "draftValue" : null
        },
        "custfriend_relation_2" : {
          "attrName" : "custfriend_relation_2",
          "attrValue" : "",
          "draftValue" : null
        },
        "custjob_salary" : {
          "attrName" : "custjob_salary",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_relation_1" : {
          "attrName" : "custfriend_relation_1",
          "attrValue" : "",
          "draftValue" : null
        },
        "loanadvice_limit" : {
          "attrName" : "loanadvice_limit",
          "attrValue" : null,
          "draftValue" : null
        },
        "loan_apply_term" : {
          "attrName" : "loan_apply_term",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarimg_inside" : {
          "attrName" : "loancarimg_inside",
          "attrValue" : "",
          "draftValue" : null
        },
        "custfriend_friend_name" : {
          "attrName" : "custfriend_friend_name",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower2_home_addr_city" : {
          "attrName" : "borrower2_home_addr_city",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarinfo_capacity" : {
          "attrName" : "loancarinfo_capacity",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancheckph_spouse" : {
          "attrName" : "loancheckph_spouse",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower3_home_addr_counties" : {
          "attrName" : "borrower3_home_addr_counties",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_house_time" : {
          "attrName" : "cust_house_time",
          "attrValue" : "2017-05-08",
          "draftValue" : null
        },
        "cust_regist_addr" : {
          "attrName" : "cust_regist_addr",
          "attrValue" : "天津/天津市/河东区/123",
          "draftValue" : null
        },
        "loanbank_addr_city" : {
          "attrName" : "loanbank_addr_city",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower3_corp_phone" : {
          "attrName" : "borrower3_corp_phone",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancar_car_type" : {
          "attrName" : "loancar_car_type",
          "attrValue" : "",
          "draftValue" : null
        },
        "borrower2_job" : {
          "attrName" : "borrower2_job",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_live_addr_city" : {
          "attrName" : "cust_live_addr_city",
          "attrValue" : "台州市",
          "draftValue" : null
        },
        "loanadvice_monthlyTerm" : {
          "attrName" : "loanadvice_monthlyTerm",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancheckinfo_credit" : {
          "attrName" : "loancheckinfo_credit",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_l4" : {
          "attrName" : "loancarrepair_mal_l4",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_l3" : {
          "attrName" : "loancarrepair_mal_l3",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_l6" : {
          "attrName" : "loancarrepair_mal_l6",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancar_ownership" : {
          "attrName" : "loancar_ownership",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarrepair_mal_l5" : {
          "attrName" : "loancarrepair_mal_l5",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower3_name" : {
          "attrName" : "borrower3_name",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancar_license_plate" : {
          "attrName" : "loancar_license_plate",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarrepair_mal_l2" : {
          "attrName" : "loancarrepair_mal_l2",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_l1" : {
          "attrName" : "loancarrepair_mal_l1",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarimg_main_drive_side" : {
          "attrName" : "loancarimg_main_drive_side",
          "attrValue" : "",
          "draftValue" : null
        },
        "custjob_company_addr" : {
          "attrName" : "custjob_company_addr",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_mal_l7" : {
          "attrName" : "loancarrepair_mal_l7",
          "attrValue" : null,
          "draftValue" : null
        },
        "loan_apply_supportFirstPay" : {
          "attrName" : "loan_apply_supportFirstPay",
          "attrValue" : "",
          "draftValue" : null
        },
        "custearn_credit_report" : {
          "attrName" : "custearn_credit_report",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_wechat" : {
          "attrName" : "cust_wechat",
          "attrValue" : "a12313",
          "draftValue" : null
        },
        "custjob_job_lvl" : {
          "attrName" : "custjob_job_lvl",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_direct_relation" : {
          "attrName" : "custfriend_direct_relation",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower3_home_addr_city" : {
          "attrName" : "borrower3_home_addr_city",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_regist_addr_city" : {
          "attrName" : "cust_regist_addr_city",
          "attrValue" : "天津市",
          "draftValue" : null
        },
        "cust_type" : {
          "attrName" : "cust_type",
          "attrValue" : "0",
          "draftValue" : null
        },
        "cust_house_spending" : {
          "attrName" : "cust_house_spending",
          "attrValue" : "123123",
          "draftValue" : null
        },
        "loancarimg_front_45" : {
          "attrName" : "loancarimg_front_45",
          "attrValue" : "",
          "draftValue" : null
        },
        "custjob_income_source" : {
          "attrName" : "custjob_income_source",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanasseth_status" : {
          "attrName" : "loanasseth_status",
          "attrValue" : null,
          "draftValue" : null
        },
        "loan_type" : {
          "attrName" : "loan_type",
          "attrValue" : "",
          "draftValue" : null
        },
        "cust_live_addr" : {
          "attrName" : "cust_live_addr",
          "attrValue" : "浙江省/台州市/天台县/dsd",
          "draftValue" : null
        },
        "borrower2_corp_name" : {
          "attrName" : "borrower2_corp_name",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancheckinfo_audit" : {
          "attrName" : "loancheckinfo_audit",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarinfo_procedure_si" : {
          "attrName" : "loancarinfo_procedure_si",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_other_relation" : {
          "attrName" : "custfriend_other_relation",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanofee_repay_day_type" : {
          "attrName" : "loanofee_repay_day_type",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_name" : {
          "attrName" : "cust_name",
          "attrValue" : "Test用户",
          "draftValue" : null
        },
        "loancar_purchase_price" : {
          "attrName" : "loancar_purchase_price",
          "attrValue" : "",
          "draftValue" : null
        },
        "loanbank_bank" : {
          "attrName" : "loanbank_bank",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_mobile" : {
          "attrName" : "cust_mobile",
          "attrValue" : "15958432312",
          "draftValue" : null
        },
        "loancarimg_back" : {
          "attrName" : "loancarimg_back",
          "attrValue" : "",
          "draftValue" : null
        },
        "loanapproval_repaymentTypes" : {
          "attrName" : "loanapproval_repaymentTypes",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancheckinfo_check" : {
          "attrName" : "loancheckinfo_check",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_other_name" : {
          "attrName" : "custfriend_other_name",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancheckinfo_yearcount" : {
          "attrName" : "loancheckinfo_yearcount",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarinfo_procedure_other" : {
          "attrName" : "loancarinfo_procedure_other",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_lock" : {
          "attrName" : "loancarrepair_lock",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanofee_gps" : {
          "attrName" : "loanofee_gps",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancontractimg_trust" : {
          "attrName" : "loancontractimg_trust",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanasseth_purchase_method" : {
          "attrName" : "loanasseth_purchase_method",
          "attrValue" : null,
          "draftValue" : null
        },
        "custjob_salary_type" : {
          "attrName" : "custjob_salary_type",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_other_company_name" : {
          "attrName" : "custfriend_other_company_name",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarimg_compulsory_insurance" : {
          "attrName" : "loancarimg_compulsory_insurance",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarinfo_geartype" : {
          "attrName" : "loancarinfo_geartype",
          "attrValue" : null,
          "draftValue" : null
        },
        "custjob_company_type" : {
          "attrName" : "custjob_company_type",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_name_4" : {
          "attrName" : "custfriend_name_4",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarimg_wheel_right" : {
          "attrName" : "loancarimg_wheel_right",
          "attrValue" : "",
          "draftValue" : null
        },
        "custfriend_name_3" : {
          "attrName" : "custfriend_name_3",
          "attrValue" : "",
          "draftValue" : null
        },
        "custjob_company_phone" : {
          "attrName" : "custjob_company_phone",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_name_2" : {
          "attrName" : "custfriend_name_2",
          "attrValue" : "",
          "draftValue" : null
        },
        "custfriend_name_1" : {
          "attrName" : "custfriend_name_1",
          "attrValue" : "",
          "draftValue" : null
        },
        "custfriend_name_0" : {
          "attrName" : "custfriend_name_0",
          "attrValue" : "aaaa",
          "draftValue" : null
        },
        "loanapproval_znjFee" : {
          "attrName" : "loanapproval_znjFee",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_phone_3" : {
          "attrName" : "custfriend_phone_3",
          "attrValue" : "",
          "draftValue" : null
        },
        "custfriend_phone_4" : {
          "attrName" : "custfriend_phone_4",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarinfo_procedure_ci" : {
          "attrName" : "loancarinfo_procedure_ci",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_engine" : {
          "attrName" : "loancarrepair_engine",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarassess_advice" : {
          "attrName" : "loancarassess_advice",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_phone_0" : {
          "attrName" : "custfriend_phone_0",
          "attrValue" : "18550000000",
          "draftValue" : null
        },
        "custfriend_phone_1" : {
          "attrName" : "custfriend_phone_1",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarimg_video" : {
          "attrName" : "loancarimg_video",
          "attrValue" : "",
          "draftValue" : null
        },
        "custfriend_phone_2" : {
          "attrName" : "custfriend_phone_2",
          "attrValue" : "",
          "draftValue" : null
        },
        "loanapproval_daylyGLFee" : {
          "attrName" : "loanapproval_daylyGLFee",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancontractimg_withhold" : {
          "attrName" : "loancontractimg_withhold",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_desc" : {
          "attrName" : "loancarrepair_desc",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarimg_front" : {
          "attrName" : "loancarimg_front",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarinfo_procedure_mot" : {
          "attrName" : "loancarinfo_procedure_mot",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanrebank_addr" : {
          "attrName" : "loanrebank_addr",
          "attrValue" : null,
          "draftValue" : null
        },
        "loan_apply_amount" : {
          "attrName" : "loan_apply_amount",
          "attrValue" : "",
          "draftValue" : null
        },
        "borrower2_mobile" : {
          "attrName" : "borrower2_mobile",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancheckinfo_asset" : {
          "attrName" : "loancheckinfo_asset",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_support_num" : {
          "attrName" : "cust_support_num",
          "attrValue" : "3",
          "draftValue" : null
        },
        "cust_license_num_invalid" : {
          "attrName" : "cust_license_num_invalid",
          "attrValue" : "2017-05-01",
          "draftValue" : null
        },
        "loanasseth_valuation" : {
          "attrName" : "loanasseth_valuation",
          "attrValue" : null,
          "draftValue" : null
        },
        "custjob_dept_name" : {
          "attrName" : "custjob_dept_name",
          "attrValue" : null,
          "draftValue" : null
        },
        "loan_apply_daylyTerm" : {
          "attrName" : "loan_apply_daylyTerm",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarimg_back_interior" : {
          "attrName" : "loancarimg_back_interior",
          "attrValue" : "",
          "draftValue" : null
        },
        "loanassethimg_month_certificate" : {
          "attrName" : "loanassethimg_month_certificate",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarinfo_body_category_2" : {
          "attrName" : "loancarinfo_body_category_2",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarinfo_body_category_1" : {
          "attrName" : "loancarinfo_body_category_1",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarinfo_body_category_3" : {
          "attrName" : "loancarinfo_body_category_3",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanofee_consulting" : {
          "attrName" : "loanofee_consulting",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanrebank_addr_province" : {
          "attrName" : "loanrebank_addr_province",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_mobile" : {
          "attrName" : "custfriend_mobile",
          "attrValue" : null,
          "draftValue" : null
        },
        "loansecurity_name2" : {
          "attrName" : "loansecurity_name2",
          "attrValue" : null,
          "draftValue" : null
        },
        "loansecurity_name3" : {
          "attrName" : "loansecurity_name3",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_live_addr_detail" : {
          "attrName" : "cust_live_addr_detail",
          "attrValue" : "dsd",
          "draftValue" : null
        },
        "loanrebank_addr_city" : {
          "attrName" : "loanrebank_addr_city",
          "attrValue" : null,
          "draftValue" : null
        },
        "loansecurity_name4" : {
          "attrName" : "loansecurity_name4",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanapproval_daylyTerm" : {
          "attrName" : "loanapproval_daylyTerm",
          "attrValue" : null,
          "draftValue" : null
        },
        "custjob_salary_date" : {
          "attrName" : "custjob_salary_date",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower2_license_num" : {
          "attrName" : "borrower2_license_num",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarimg_business_insurance" : {
          "attrName" : "loancarimg_business_insurance",
          "attrValue" : "",
          "draftValue" : null
        },
        "loan_mort_type" : {
          "attrName" : "loan_mort_type",
          "attrValue" : "",
          "draftValue" : null
        },
        "loanasseth_desc" : {
          "attrName" : "loanasseth_desc",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_child_count" : {
          "attrName" : "cust_child_count",
          "attrValue" : "3",
          "draftValue" : null
        },
        "loancar_driving_position" : {
          "attrName" : "loancar_driving_position",
          "attrValue" : "",
          "draftValue" : null
        },
        "loansecurity_name1" : {
          "attrName" : "loansecurity_name1",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarimg_main_door" : {
          "attrName" : "loancarimg_main_door",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarrepair_lock_o" : {
          "attrName" : "loancarrepair_lock_o",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancar_num" : {
          "attrName" : "loancar_num",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarrepair_lock_p" : {
          "attrName" : "loancarrepair_lock_p",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_mobile2" : {
          "attrName" : "cust_mobile2",
          "attrValue" : "15958432312",
          "draftValue" : null
        },
        "loanapproval_yearlyRate" : {
          "attrName" : "loanapproval_yearlyRate",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower2_role" : {
          "attrName" : "borrower2_role",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_other_mobile" : {
          "attrName" : "custfriend_other_mobile",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanofee_repay_day" : {
          "attrName" : "loanofee_repay_day",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanasseth_address_counties" : {
          "attrName" : "loanasseth_address_counties",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanapproval_daylyZHFee" : {
          "attrName" : "loanapproval_daylyZHFee",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancontractimg_loan" : {
          "attrName" : "loancontractimg_loan",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanofee_gpsservice" : {
          "attrName" : "loanofee_gpsservice",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarimg_main_drive" : {
          "attrName" : "loancarimg_main_drive",
          "attrValue" : "",
          "draftValue" : null
        },
        "loanadvice_daylyTerm" : {
          "attrName" : "loanadvice_daylyTerm",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanapproval_loan_term" : {
          "attrName" : "loanapproval_loan_term",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanrebank_branch" : {
          "attrName" : "loanrebank_branch",
          "attrValue" : null,
          "draftValue" : null
        },
        "loansecurityimg_form" : {
          "attrName" : "loansecurityimg_form",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancar_car_bms_brand" : {
          "attrName" : "loancar_car_bms_brand",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancar_car_color" : {
          "attrName" : "loancar_car_color",
          "attrValue" : "",
          "draftValue" : null
        },
        "cust_live_addr_counties" : {
          "attrName" : "cust_live_addr_counties",
          "attrValue" : "天台县",
          "draftValue" : null
        },
        "borrower3_home_addr_detail" : {
          "attrName" : "borrower3_home_addr_detail",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_know_4" : {
          "attrName" : "custfriend_know_4",
          "attrValue" : "0",
          "draftValue" : null
        },
        "custjob_income_month" : {
          "attrName" : "custjob_income_month",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_house_type" : {
          "attrName" : "cust_house_type",
          "attrValue" : "2",
          "draftValue" : null
        },
        "loancheckinfo_person" : {
          "attrName" : "loancheckinfo_person",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_know_2" : {
          "attrName" : "custfriend_know_2",
          "attrValue" : "0",
          "draftValue" : null
        },
        "loanadvice_repaymentTypes" : {
          "attrName" : "loanadvice_repaymentTypes",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_know_3" : {
          "attrName" : "custfriend_know_3",
          "attrValue" : "0",
          "draftValue" : null
        },
        "custfriend_know_0" : {
          "attrName" : "custfriend_know_0",
          "attrValue" : "1",
          "draftValue" : null
        },
        "custfriend_know_1" : {
          "attrName" : "custfriend_know_1",
          "attrValue" : "0",
          "draftValue" : null
        },
        "loanofee_park" : {
          "attrName" : "loanofee_park",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_accid_lvl" : {
          "attrName" : "loancarrepair_accid_lvl",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancar_frame_number" : {
          "attrName" : "loancar_frame_number",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarimg_front_glass" : {
          "attrName" : "loancarimg_front_glass",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancontractimg_car" : {
          "attrName" : "loancontractimg_car",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarassessimg_pic" : {
          "attrName" : "loancarassessimg_pic",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower2_home_addr_detail" : {
          "attrName" : "borrower2_home_addr_detail",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanasseth_address_province" : {
          "attrName" : "loanasseth_address_province",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanadvice_supportFirstPay" : {
          "attrName" : "loanadvice_supportFirstPay",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanasseth_address" : {
          "attrName" : "loanasseth_address",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower3_job" : {
          "attrName" : "borrower3_job",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarinfo_procedure" : {
          "attrName" : "loancarinfo_procedure",
          "attrValue" : null,
          "draftValue" : null
        },
        "loan_has" : {
          "attrName" : "loan_has",
          "attrValue" : "",
          "draftValue" : null
        },
        "custearn_security_fund" : {
          "attrName" : "custearn_security_fund",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower2_home_addr_province" : {
          "attrName" : "borrower2_home_addr_province",
          "attrValue" : null,
          "draftValue" : null
        },
        "custjob_identity" : {
          "attrName" : "custjob_identity",
          "attrValue" : "2",
          "draftValue" : null
        },
        "custearn_business_licence" : {
          "attrName" : "custearn_business_licence",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancar_purchase_date" : {
          "attrName" : "loancar_purchase_date",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancheckinfo_finance" : {
          "attrName" : "loancheckinfo_finance",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarinfo_mileage" : {
          "attrName" : "loancarinfo_mileage",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanapproval_wyFee" : {
          "attrName" : "loanapproval_wyFee",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarimg_nameplate" : {
          "attrName" : "loancarimg_nameplate",
          "attrValue" : "",
          "draftValue" : null
        },
        "loancarimg_back_box" : {
          "attrName" : "loancarimg_back_box",
          "attrValue" : "",
          "draftValue" : null
        },
        "loanbank_addr" : {
          "attrName" : "loanbank_addr",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_regist_addr_counties" : {
          "attrName" : "cust_regist_addr_counties",
          "attrValue" : "河东区",
          "draftValue" : null
        },
        "cust_live_addr_province" : {
          "attrName" : "cust_live_addr_province",
          "attrValue" : "浙江省",
          "draftValue" : null
        },
        "loan_usage_other" : {
          "attrName" : "loan_usage_other",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_education" : {
          "attrName" : "cust_education",
          "attrValue" : "0",
          "draftValue" : null
        },
        "loan_mortgage_user" : {
          "attrName" : "loan_mortgage_user",
          "attrValue" : "",
          "draftValue" : null
        },
        "loanadvice_loan" : {
          "attrName" : "loanadvice_loan",
          "attrValue" : null,
          "draftValue" : null
        },
        "borrower2_home_addr" : {
          "attrName" : "borrower2_home_addr",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancarrepair_info" : {
          "attrName" : "loancarrepair_info",
          "attrValue" : null,
          "draftValue" : null
        },
        "custfriend_friend_mobile" : {
          "attrName" : "custfriend_friend_mobile",
          "attrValue" : null,
          "draftValue" : null
        },
        "custjob_industry1" : {
          "attrName" : "custjob_industry1",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancar_car_bms_series" : {
          "attrName" : "loancar_car_bms_series",
          "attrValue" : "",
          "draftValue" : null
        },
        "custjob_company_addr_counties" : {
          "attrName" : "custjob_company_addr_counties",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancheckph_company" : {
          "attrName" : "loancheckph_company",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanasseth_ownership" : {
          "attrName" : "loanasseth_ownership",
          "attrValue" : null,
          "draftValue" : null
        },
        "cust_regist_addr_province" : {
          "attrName" : "cust_regist_addr_province",
          "attrValue" : "天津",
          "draftValue" : null
        },
        "loancarimg_drive_license_fu" : {
          "attrName" : "loancarimg_drive_license_fu",
          "attrValue" : "",
          "draftValue" : null
        },
        "loanapproval_limit" : {
          "attrName" : "loanapproval_limit",
          "attrValue" : null,
          "draftValue" : null
        },
        "loancontractimg_transfer" : {
          "attrName" : "loancontractimg_transfer",
          "attrValue" : null,
          "draftValue" : null
        },
        "custjob_entry_time" : {
          "attrName" : "custjob_entry_time",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanapproval_monthlyTerm" : {
          "attrName" : "loanapproval_monthlyTerm",
          "attrValue" : null,
          "draftValue" : null
        },
        "loanrebank_account_no" : {
          "attrName" : "loanrebank_account_no",
          "attrValue" : null,
          "draftValue" : null
        }
      },
      "defaultHidden" : {
        "taskId" : "475013",
        "customerId" : "b1734de096ba4ea998bb85a33ccc92dc",
        "bpDefKey" : "cydprocess",
        "bpDefId" : "4d49b787315a11e783df0800270c7d97",
        "bpId" : "4fb35e516b8c4ada8997544dc5c2313e",
        "deptId" : "1",
        "productId" : "CYD"
      },
      "operations" : [ ],
      "checkrules" : {
        "loancar_registration_date" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancar_registration_date",
          "fieldName" : "初次登记日期",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custjob_reg_date" : [ ],
        "loansecurity_desc4" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过100",
          "fieldKey" : "loansecurity_desc4",
          "fieldName" : "说明",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "100",
            "min" : "1"
          }
        } ],
        "loanrebank_bank" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanrebank_bank",
          "fieldName" : "还款银行开户行",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loansecurity_desc2" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过100",
          "fieldKey" : "loansecurity_desc2",
          "fieldName" : "说明",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "100",
            "min" : "1"
          }
        } ],
        "loansecurity_desc3" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过100",
          "fieldKey" : "loansecurity_desc3",
          "fieldName" : "说明",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "100",
            "min" : "1"
          }
        } ],
        "cust_regist_addr_detail" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过30",
          "fieldKey" : "cust_regist_addr_detail",
          "fieldName" : "户口所在地详细",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "30",
            "min" : "1"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "cust_regist_addr_detail",
          "fieldName" : "户口所在地详细",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loansecurity_desc1" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过100",
          "fieldKey" : "loansecurity_desc1",
          "fieldName" : "说明",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "100",
            "min" : "1"
          }
        } ],
        "loancarassess_price" : [ {
          "ruleType" : "decimal",
          "ruleLevel" : "field",
          "message" : "请输入在0到9999之间的数字，小数点后最多可输入两位",
          "fieldKey" : "loancarassess_price",
          "fieldName" : "评估师估价",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "0",
            "max" : "9999",
            "digits" : "2"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarassess_price",
          "fieldName" : "评估师估价",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarimg_vehicle_registration" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_vehicle_registration",
          "fieldName" : "车辆登记证书",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarimg_vehicle_registration",
          "fieldName" : "车辆登记证书",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "cust_marriage" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "cust_marriage",
          "fieldName" : "婚姻状况",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancheckph_phone1" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loancheckph_phone1",
          "fieldName" : "移动电话1",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        } ],
        "custjob_turnover_month" : [ ],
        "loanassethimg_mortgage_contract" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loanassethimg_mortgage_contract",
          "fieldName" : "抵押贷款合同",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loancarimg_instrument_panel" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_instrument_panel",
          "fieldName" : "仪表盘照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loancheckph_phone2" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loancheckph_phone2",
          "fieldName" : "移动电话2",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        } ],
        "loancheckph_friends" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loancheckph_friends",
          "fieldName" : "亲友手机",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        } ],
        "borrower3_license_num" : [ ],
        "loancarimg_copilot_drive_glass" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_copilot_drive_glass",
          "fieldName" : "副驾后玻璃码照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loanbank_addr_province" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanbank_addr_province",
          "fieldName" : "借款银行开户地省",
          "parent" : "loanbank_addr",
          "condition" : null,
          "detail" : null
        } ],
        "loancontractimg_gps" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "loancontractimg_gps",
          "fieldName" : "GPS免责声明书",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loancheckph_telephone" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loancheckph_telephone",
          "fieldName" : "住宅电话",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        } ],
        "loancheckph_technical_title" : [ ],
        "loancarimg_car_owner" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_car_owner",
          "fieldName" : "车主与车辆合照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "custjob_industry" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "custjob_industry",
          "fieldName" : "所属行业",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "cust_email" : [ {
          "ruleType" : "email",
          "ruleLevel" : "field",
          "message" : "请输入正确的邮箱地址",
          "fieldKey" : "cust_email",
          "fieldName" : "邮箱地址",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarimg_main_drive_glass" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_main_drive_glass",
          "fieldName" : "主驾前玻璃码照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loancar_engine_number" : [ {
          "ruleType" : "regexp",
          "ruleLevel" : "field",
          "message" : "请输入正确发动机号",
          "fieldKey" : "loancar_engine_number",
          "fieldName" : "发动机号",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "regexp" : "^[a-zA-Z0-9]{0,10}$"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancar_engine_number",
          "fieldName" : "发动机号",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custjob_company_addr_city" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "custjob_company_addr_city",
          "fieldName" : "单位地址市",
          "parent" : "custjob_company_addr",
          "condition" : null,
          "detail" : null
        } ],
        "loanasseth_purchase_date" : [ ],
        "loanadvice_eachTimes" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanadvice_eachTimes",
          "fieldName" : "建议每期时长",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanadvice_repaymentTypes",
            "operator" : "!=",
            "value" : "3"
          } ],
          "detail" : null
        } ],
        "loancarimg_other" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_other",
          "fieldName" : "其他",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "cust_phone" : [ {
          "ruleType" : "telephone",
          "ruleLevel" : "field",
          "message" : "请输入正确的电话",
          "fieldKey" : "cust_phone",
          "fieldName" : "住宅电话",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "borrower2_name" : [ ],
        "loanbank_account_no" : [ {
          "ruleType" : "regexp",
          "ruleLevel" : "field",
          "message" : "请输入正确银行卡号",
          "fieldKey" : "loanbank_account_no",
          "fieldName" : "借款银行账号",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "regexp" : "^\\d{16}|\\d{19}$"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanbank_account_no",
          "fieldName" : "借款银行账号",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "cust_qq" : [ {
          "ruleType" : "regexp",
          "ruleLevel" : "field",
          "message" : "请输入正确的QQ号",
          "fieldKey" : "cust_qq",
          "fieldName" : "QQ",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "regexp" : "^\\d{5,15}$"
          }
        } ],
        "borrower2_home_addr_counties" : [ ],
        "cust_license_num" : [ {
          "ruleType" : "idnumber",
          "ruleLevel" : "field",
          "message" : "请输入正确的身份证号",
          "fieldKey" : "cust_license_num",
          "fieldName" : "身份证号",
          "parent" : null,
          "condition" : null,
          "detail" : null
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "cust_license_num",
          "fieldName" : "身份证号",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancar_car_bms" : [ ],
        "loancarrepair_mal_c7" : [ ],
        "loancarrepair_mal_c6" : [ ],
        "loanapproval_monthlyZHFee" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_monthlyZHFee",
          "fieldName" : "月综合利率",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanapproval_repaymentTypes",
            "operator" : "!=",
            "value" : "3"
          } ],
          "detail" : null
        } ],
        "borrower3_mobile" : [ ],
        "loanasseth_address_detail" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到50位字符",
          "fieldKey" : "loanasseth_address_detail",
          "fieldName" : "房产地址详细地址",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "50"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanasseth_address_detail",
          "fieldName" : "房产地址详细地址",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanasseth_has",
            "operator" : "==",
            "value" : "1"
          } ],
          "detail" : null
        } ],
        "loanapproval_supportFirstPay" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_supportFirstPay",
          "fieldName" : "首还款支付方式",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancar_registration_model" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancar_registration_model",
          "fieldName" : "登记证车型号:",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanapproval_bzjFee" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_bzjFee",
          "fieldName" : "保证金率 ",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanadvice_need" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanadvice_need",
          "fieldName" : "是否需要上门考察",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanassethimg_owner_certificate" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loanassethimg_owner_certificate",
          "fieldName" : "房产证",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loancarrepair_mal_c1" : [ ],
        "loanasseth_has" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanasseth_has",
          "fieldName" : "是否有房产",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custjob_company_addr_detail" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过30",
          "fieldKey" : "custjob_company_addr_detail",
          "fieldName" : "单位地址详细",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "30",
            "min" : "1"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "custjob_company_addr_detail",
          "fieldName" : "单位地址详细",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarrepair_mal_c3" : [ ],
        "loancarrepair_mal_c2" : [ ],
        "loancarrepair_mal_c5" : [ ],
        "custjob_company_addr_province" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "custjob_company_addr_province",
          "fieldName" : "单位地址省",
          "parent" : "custjob_company_addr",
          "condition" : null,
          "detail" : null
        } ],
        "loancarrepair_mal_c4" : [ ],
        "loanapproval_daylyRate" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_daylyRate",
          "fieldName" : "日利率",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanapproval_repaymentTypes",
            "operator" : "==",
            "value" : "3"
          } ],
          "detail" : null
        } ],
        "loancarrepair_mal_p7" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loancarrepair_mal_p7",
          "fieldName" : "事故位置7",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        } ],
        "loanbank_account_name" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loanbank_account_name",
          "fieldName" : "借款账户户名",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanbank_account_name",
          "fieldName" : "借款账户户名",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarinfo_keys" : [ {
          "ruleType" : "integer",
          "ruleLevel" : "field",
          "message" : "请输入在0到20之间的整数",
          "fieldKey" : "loancarinfo_keys",
          "fieldName" : "车辆钥匙",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "0",
            "max" : "20"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarinfo_keys",
          "fieldName" : "车辆钥匙",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custfriend_friend_know" : [ ],
        "loancarrepair_mal_p3" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loancarrepair_mal_p3",
          "fieldName" : "事故位置3",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        } ],
        "loancarrepair_mal_p4" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loancarrepair_mal_p4",
          "fieldName" : "事故位置4",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        } ],
        "cust_idcard_ver" : [ ],
        "loancar_approved_passenger" : [ {
          "ruleType" : "integer",
          "ruleLevel" : "field",
          "message" : "请输入在1到60之间的整数",
          "fieldKey" : "loancar_approved_passenger",
          "fieldName" : "核定载客",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "60"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancar_approved_passenger",
          "fieldName" : "核定载客",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarrepair_mal_p5" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loancarrepair_mal_p5",
          "fieldName" : "事故位置5",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        } ],
        "borrower3_role" : [ ],
        "loancarrepair_mal_p6" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loancarrepair_mal_p6",
          "fieldName" : "事故位置6",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        } ],
        "loanapproval_period" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_period",
          "fieldName" : "审批期限",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarassessimg_group_photo" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "loancarassessimg_group_photo",
          "fieldName" : "评估师与车辆合照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarassessimg_group_photo",
          "fieldName" : "评估师与车辆合照",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarrepair_mal_p1" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loancarrepair_mal_p1",
          "fieldName" : "事故位置1",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        } ],
        "loancarimg_insurance_policy" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_insurance_policy",
          "fieldName" : "车辆保险单",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loancarrepair_mal_p2" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loancarrepair_mal_p2",
          "fieldName" : "事故位置2",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        } ],
        "borrower3_corp_name" : [ ],
        "borrower2_relation" : [ ],
        "custfriend" : [ ],
        "custearn_bank_bill" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "custearn_bank_bill",
          "fieldName" : "银行流水",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loanbank_branch" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanbank_branch",
          "fieldName" : "借款银行支行",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanapproval_monthlyGLFee" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_monthlyGLFee",
          "fieldName" : "月管理费率",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanapproval_repaymentTypes",
            "operator" : "!=",
            "value" : "3"
          } ],
          "detail" : null
        } ],
        "loan_usage" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loan_usage",
          "fieldName" : "借款用途",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarimg_drive_license" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_drive_license",
          "fieldName" : "行驶证主页",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarimg_drive_license",
          "fieldName" : "行驶证主页",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loandebit_amount" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loandebit_amount",
          "fieldName" : "放款金额",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanofee_gpsservice_pay" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanofee_gpsservice_pay",
          "fieldName" : "GPS服务费支付方式",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancontractimg_service" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "loancontractimg_service",
          "fieldName" : "借款咨询服务协议",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "custfriend_company_name" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过40",
          "fieldKey" : "custfriend_company_name",
          "fieldName" : "单位名称",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "40"
          }
        } ],
        "loanofee_park_pay" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanofee_park_pay",
          "fieldName" : "停车费支付方式",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanasseth_address_city" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanasseth_address_city",
          "fieldName" : "房产地址市",
          "parent" : "loanasseth_address",
          "condition" : [ {
            "fieldKey" : "loanasseth_has",
            "operator" : "==",
            "value" : "1"
          } ],
          "detail" : null
        } ],
        "loancontractimg_attorney" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "loancontractimg_attorney",
          "fieldName" : "授权委托书",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancontractimg_attorney",
          "fieldName" : "授权委托书",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custfriend_friend_company_name" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过40",
          "fieldKey" : "custfriend_friend_company_name",
          "fieldName" : "单位名称",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "40"
          }
        } ],
        "loan_apply_repaymentTypes" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loan_apply_repaymentTypes",
          "fieldName" : "还款方式",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarimg_wheel_left" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_wheel_left",
          "fieldName" : "左方向盘照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loanassethimg_purchase_contract" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loanassethimg_purchase_contract",
          "fieldName" : "房屋购房合同",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loancarinfo_use_nature" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarinfo_use_nature",
          "fieldName" : "使用性质",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancheckinfo_data" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过40",
          "fieldKey" : "loancheckinfo_data",
          "fieldName" : "资料核查",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "40",
            "min" : "1"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancheckinfo_data",
          "fieldName" : "资料核查",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custfriend_company_name_4" : [ ],
        "custfriend_spouse_name" : [ {
          "ruleType" : "regexp",
          "ruleLevel" : "field",
          "message" : "请输入2-20个字，只支持中文或英文",
          "fieldKey" : "custfriend_spouse_name",
          "fieldName" : "配偶姓名",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "regexp" : "^[一-龥_a-zA-Z]{2,20}$"
          }
        } ],
        "borrower3_relation" : [ ],
        "cust_come_time" : [ ],
        "loan_apply_eachTimes" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loan_apply_eachTimes",
          "fieldName" : "每期时长",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loan_apply_repaymentTypes",
            "operator" : "!=",
            "value" : "3"
          } ],
          "detail" : null
        } ],
        "loancarrepair_info_b" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarrepair_info_b",
          "fieldName" : "保养情况",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancar_yearcount" : [ {
          "ruleType" : "integer",
          "ruleLevel" : "field",
          "message" : "请输入在0到100之间",
          "fieldKey" : "loancar_yearcount",
          "fieldName" : "1年内抵押，质押和过户次数",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "0",
            "max" : "100"
          }
        } ],
        "custimg_idcard1" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "custimg_idcard1",
          "fieldName" : "身份证照正面",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "custimg_idcard1",
          "fieldName" : "身份证照正面",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "cust_gender" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "cust_gender",
          "fieldName" : "性别",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custfriend_company_name_1" : [ ],
        "loancarinfo_detail_config_other" : [ ],
        "custfriend_company_name_0" : [ ],
        "custfriend_company_name_3" : [ ],
        "custimg_idcard2" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "custimg_idcard2",
          "fieldName" : "身份证照反面",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "custimg_idcard2",
          "fieldName" : "身份证照反面",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custfriend_company_name_2" : [ ],
        "loancarrepair_accident" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarrepair_accident",
          "fieldName" : "有无事故",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancontractimg_r_mortgage" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "loancontractimg_r_mortgage",
          "fieldName" : "反抵押合同",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancontractimg_r_mortgage",
          "fieldName" : "反抵押合同",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "borrower3_home_addr_province" : [ ],
        "loancar_car_fuel" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancar_car_fuel",
          "fieldName" : "燃料种类",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custjob_company_name" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过40",
          "fieldKey" : "custjob_company_name",
          "fieldName" : "单位名称",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "40",
            "min" : "1"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "custjob_company_name",
          "fieldName" : "单位名称",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loandebit_name" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loandebit_name",
          "fieldName" : "放款人",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarinfo_detail_config" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarinfo_detail_config",
          "fieldName" : "详细配置",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loansecurity_id1" : [ ],
        "loan_apply" : [ ],
        "loanapproval_eachTimes" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_eachTimes",
          "fieldName" : "每期时长",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanapproval_repaymentTypes",
            "operator" : "!=",
            "value" : "3"
          } ],
          "detail" : null
        } ],
        "loan_repayment_method" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loan_repayment_method",
          "fieldName" : "还款方式",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancar_year_num" : [ ],
        "loanasseth_type" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanasseth_type",
          "fieldName" : "房产类型",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanasseth_has",
            "operator" : "==",
            "value" : "1"
          } ],
          "detail" : null
        } ],
        "loan_apply_monthlyTerm" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loan_apply_monthlyTerm",
          "fieldName" : "借款期限",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loan_apply_repaymentTypes",
            "operator" : "!=",
            "value" : "3"
          } ],
          "detail" : null
        } ],
        "loanrebank_account_name" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loanrebank_account_name",
          "fieldName" : "还款账户户名",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanrebank_account_name",
          "fieldName" : "还款账户户名",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loansecurity_id4" : [ ],
        "loansecurity_status2" : [ ],
        "loancheckinfo_car" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过40",
          "fieldKey" : "loancheckinfo_car",
          "fieldName" : "车辆情况",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "40",
            "min" : "1"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancheckinfo_car",
          "fieldName" : "车辆情况",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loansecurity_status1" : [ ],
        "loansecurity_status4" : [ ],
        "loansecurity_id2" : [ ],
        "loansecurity_id3" : [ ],
        "loansecurity_status3" : [ ],
        "custfriend_relation_0" : [ ],
        "loanapproval_monthlyRate" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_monthlyRate",
          "fieldName" : "月利率",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanapproval_repaymentTypes",
            "operator" : "!=",
            "value" : "3"
          } ],
          "detail" : null
        } ],
        "borrower2_corp_phone" : [ ],
        "custfriend_relation_4" : [ ],
        "custfriend_relation_3" : [ ],
        "custfriend_relation_2" : [ ],
        "loancar_car_bms_model" : [ ],
        "custfriend_relation_1" : [ ],
        "custjob_salary" : [ {
          "ruleType" : "decimal",
          "ruleLevel" : "field",
          "message" : "仅支持0-1000000的数字，小数点后最多可输入两位",
          "fieldKey" : "custjob_salary",
          "fieldName" : "月均工资",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "0",
            "max" : "1000000",
            "digits" : "2"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "custjob_salary",
          "fieldName" : "月均工资",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanadvice_limit" : [ {
          "ruleType" : "decimal",
          "ruleLevel" : "field",
          "message" : "请输入在0到100000000之间的数字，小数点后最多可输入两位",
          "fieldKey" : "loanadvice_limit",
          "fieldName" : "建议额度",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "0",
            "max" : "100000000",
            "digits" : "2"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanadvice_limit",
          "fieldName" : "建议额度",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loan_apply_term" : [ ],
        "loancarimg_inside" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_inside",
          "fieldName" : "机仓照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "custfriend_friend_name" : [ {
          "ruleType" : "regexp",
          "ruleLevel" : "field",
          "message" : "请输入2-20个字，只支持中文或英文",
          "fieldKey" : "custfriend_friend_name",
          "fieldName" : "亲属/朋友姓名",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "regexp" : "^[一-龥_a-zA-Z]{2,20}$"
          }
        } ],
        "borrower2_home_addr_city" : [ ],
        "loancarinfo_capacity" : [ {
          "ruleType" : "decimal",
          "ruleLevel" : "field",
          "message" : "请输入在1到20之间的数字，小数点后最多可输入两位",
          "fieldKey" : "loancarinfo_capacity",
          "fieldName" : "排量",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20",
            "digits" : "2"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarinfo_capacity",
          "fieldName" : "排量",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "borrower3_home_addr_counties" : [ ],
        "loancheckph_spouse" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loancheckph_spouse",
          "fieldName" : "配偶手机",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        } ],
        "cust_house_time" : [ ],
        "cust_regist_addr" : [ ],
        "loanbank_addr_city" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanbank_addr_city",
          "fieldName" : "借款银行开户地市",
          "parent" : "loanbank_addr",
          "condition" : null,
          "detail" : null
        } ],
        "borrower3_corp_phone" : [ ],
        "loancar_car_type" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancar_car_type",
          "fieldName" : "车辆类型",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "borrower2_job" : [ ],
        "cust_live_addr_city" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "cust_live_addr_city",
          "fieldName" : "现住址市",
          "parent" : "cust_live_addr",
          "condition" : null,
          "detail" : null
        } ],
        "loanadvice_monthlyTerm" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanadvice_monthlyTerm",
          "fieldName" : "建议借款期限",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanadvice_repaymentTypes",
            "operator" : "!=",
            "value" : "3"
          } ],
          "detail" : null
        } ],
        "loancheckinfo_credit" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过40",
          "fieldKey" : "loancheckinfo_credit",
          "fieldName" : "征信情况",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "40",
            "min" : "1"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancheckinfo_credit",
          "fieldName" : "征信情况",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarrepair_mal_l4" : [ ],
        "loancarrepair_mal_l3" : [ ],
        "loancarrepair_mal_l6" : [ ],
        "loancarrepair_mal_l5" : [ ],
        "loancar_ownership" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancar_ownership",
          "fieldName" : "车辆归属",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "borrower3_name" : [ ],
        "loancar_license_plate" : [ {
          "ruleType" : "regexp",
          "ruleLevel" : "field",
          "message" : "请输入正确车牌号",
          "fieldKey" : "loancar_license_plate",
          "fieldName" : "车牌号码",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "regexp" : "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancar_license_plate",
          "fieldName" : "车牌号码",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarrepair_mal_l2" : [ ],
        "loancarrepair_mal_l1" : [ ],
        "loancarimg_main_drive_side" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_main_drive_side",
          "fieldName" : "主驾驶侧照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "custjob_company_addr" : [ ],
        "loancarrepair_mal_l7" : [ ],
        "loan_apply_supportFirstPay" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loan_apply_supportFirstPay",
          "fieldName" : "首还款支付方式",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custearn_credit_report" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "custearn_credit_report",
          "fieldName" : "央行征信报告",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "cust_wechat" : [ {
          "ruleType" : "regexp",
          "ruleLevel" : "field",
          "message" : "请输入正确的微信账号",
          "fieldKey" : "cust_wechat",
          "fieldName" : "微信",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "regexp" : "^[a-zA-Z][a-zA-Z0-9_]*$"
          }
        } ],
        "custjob_job_lvl" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "custjob_job_lvl",
          "fieldName" : "职位",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custfriend_direct_relation" : [ ],
        "borrower3_home_addr_city" : [ ],
        "cust_type" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "cust_type",
          "fieldName" : "客户类型",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "cust_regist_addr_city" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "cust_regist_addr_city",
          "fieldName" : "户口所在地市",
          "parent" : "cust_regist_addr",
          "condition" : null,
          "detail" : null
        } ],
        "cust_house_spending" : [ {
          "ruleType" : "decimal",
          "ruleLevel" : "field",
          "message" : "仅支持0-1000000的数字，小数点后最多可输入两位",
          "fieldKey" : "cust_house_spending",
          "fieldName" : "每月家庭支出",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "0",
            "max" : "1000000",
            "digits" : "2"
          }
        } ],
        "loancarimg_front_45" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_front_45",
          "fieldName" : "车前45度照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "custjob_income_source" : [ ],
        "loanasseth_status" : [ ],
        "loandebit_id" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loandebit_id",
          "fieldName" : "放款编号",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loan_type" : [ ],
        "loan_apply_period" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loan_apply_period",
          "fieldName" : "申请期限",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "cust_live_addr" : [ ],
        "borrower2_corp_name" : [ ],
        "loancarinfo_procedure_si" : [ ],
        "loancheckinfo_audit" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过40",
          "fieldKey" : "loancheckinfo_audit",
          "fieldName" : "审核分析",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "40",
            "min" : "1"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancheckinfo_audit",
          "fieldName" : "审核分析",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custfriend_other_relation" : [ ],
        "loanofee_repay_day_type" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanofee_repay_day_type",
          "fieldName" : "选择还款日",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "cust_name" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "cust_name",
          "fieldName" : "客户姓名",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanbank_bank" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanbank_bank",
          "fieldName" : "借款银行开户行",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancar_purchase_price" : [ {
          "ruleType" : "decimal",
          "ruleLevel" : "field",
          "message" : "请输入在1到99999999之间的数字，小数点后最多可输入两位",
          "fieldKey" : "loancar_purchase_price",
          "fieldName" : "购买价格",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "99999999",
            "digits" : "2"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancar_purchase_price",
          "fieldName" : "购买价格",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarimg_back" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_back",
          "fieldName" : "正后照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "cust_mobile" : [ {
          "ruleType" : "phone",
          "ruleLevel" : "field",
          "message" : "请输入正确的手机号",
          "fieldKey" : "cust_mobile",
          "fieldName" : "手机号1",
          "parent" : null,
          "condition" : null,
          "detail" : null
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "cust_mobile",
          "fieldName" : "手机号1",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanapproval_repaymentTypes" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_repaymentTypes",
          "fieldName" : "还款方式",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loandebitimg_voucher" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loandebitimg_voucher",
          "fieldName" : "放款凭证",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancheckinfo_check" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过40",
          "fieldKey" : "loancheckinfo_check",
          "fieldName" : "风险核查",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "40",
            "min" : "1"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancheckinfo_check",
          "fieldName" : "风险核查",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custfriend_other_name" : [ {
          "ruleType" : "regexp",
          "ruleLevel" : "field",
          "message" : "请输入2-20个字，只支持中文或英文",
          "fieldKey" : "custfriend_other_name",
          "fieldName" : "亲属/朋友姓名",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "regexp" : "^[一-龥_a-zA-Z]{2,20}$"
          }
        } ],
        "loancheckinfo_yearcount" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过40",
          "fieldKey" : "loancheckinfo_yearcount",
          "fieldName" : "1年内抵押，质押和过户次数",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "40",
            "min" : "1"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancheckinfo_yearcount",
          "fieldName" : "1年内抵押，质押和过户次数",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarinfo_procedure_other" : [ ],
        "loanofee_gps" : [ {
          "ruleType" : "decimal",
          "ruleLevel" : "field",
          "message" : "请输入在0到100000000之间的数字，小数点后最多可输入两位",
          "fieldKey" : "loanofee_gps",
          "fieldName" : "GPS安装费",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "0",
            "max" : "100000000",
            "digits" : "2"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanofee_gps",
          "fieldName" : "GPS安装费",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarrepair_lock" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarrepair_lock",
          "fieldName" : "有无暗锁",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancontractimg_trust" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "loancontractimg_trust",
          "fieldName" : "委托担保合同",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancontractimg_trust",
          "fieldName" : "委托担保合同",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanasseth_purchase_method" : [ ],
        "custjob_salary_type" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "custjob_salary_type",
          "fieldName" : "工资发放形式",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custfriend_other_company_name" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过40",
          "fieldKey" : "custfriend_other_company_name",
          "fieldName" : "单位名称",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "40"
          }
        } ],
        "loancarimg_compulsory_insurance" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_compulsory_insurance",
          "fieldName" : "交强险保单合同",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarimg_compulsory_insurance",
          "fieldName" : "交强险保单合同",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarinfo_geartype" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarinfo_geartype",
          "fieldName" : "档位形式",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custjob_company_type" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "custjob_company_type",
          "fieldName" : "单位性质",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custfriend_name_4" : [ ],
        "custjob_company_phone" : [ {
          "ruleType" : "telephone",
          "ruleLevel" : "field",
          "message" : "请输入正确的电话",
          "fieldKey" : "custjob_company_phone",
          "fieldName" : "单位电话",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarimg_wheel_right" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_wheel_right",
          "fieldName" : "右方向盘照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "custfriend_name_3" : [ ],
        "custfriend_name_2" : [ ],
        "custfriend_name_1" : [ ],
        "custfriend_name_0" : [ ],
        "loanapproval_znjFee" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_znjFee",
          "fieldName" : "滞纳金率",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custfriend_phone_3" : [ ],
        "loancarinfo_procedure_ci" : [ ],
        "custfriend_phone_4" : [ ],
        "loancarrepair_engine" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarrepair_engine",
          "fieldName" : "发动机大修",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarassess_advice" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到50位字符",
          "fieldKey" : "loancarassess_advice",
          "fieldName" : "评估建议",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "50"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarassess_advice",
          "fieldName" : "评估建议",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custfriend_phone_0" : [ ],
        "custfriend_phone_1" : [ ],
        "loancarimg_video" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传mp4,mov格式的文件",
          "fieldKey" : "loancarimg_video",
          "fieldName" : "车辆视频",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "mp4,mov",
            "type" : "video/mp4,video/quicktime"
          }
        } ],
        "custfriend_phone_2" : [ ],
        "loanapproval_daylyGLFee" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_daylyGLFee",
          "fieldName" : "日管理利率 ",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanapproval_repaymentTypes",
            "operator" : "==",
            "value" : "3"
          } ],
          "detail" : null
        } ],
        "loancontractimg_withhold" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "loancontractimg_withhold",
          "fieldName" : "代扣协议",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loancarrepair_desc" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loancarrepair_desc",
          "fieldName" : "整车描述",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarrepair_desc",
          "fieldName" : "整车描述",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loancarrepair_accident",
            "operator" : "==",
            "value" : "1"
          } ],
          "detail" : null
        } ],
        "loancarimg_front" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_front",
          "fieldName" : "车辆正面照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loanrebank_addr" : [ ],
        "loancarinfo_procedure_mot" : [ ],
        "loan_apply_amount" : [ {
          "ruleType" : "decimal",
          "ruleLevel" : "field",
          "message" : "仅支持0-90000000的数字，小数点后最多可输入两位",
          "fieldKey" : "loan_apply_amount",
          "fieldName" : "申请金额",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "0",
            "max" : "90000000",
            "digits" : "2"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loan_apply_amount",
          "fieldName" : "申请金额",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "borrower2_mobile" : [ ],
        "loancheckinfo_asset" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过40",
          "fieldKey" : "loancheckinfo_asset",
          "fieldName" : "资产分析",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "40",
            "min" : "1"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancheckinfo_asset",
          "fieldName" : "资产分析",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "cust_support_num" : [ {
          "ruleType" : "integer",
          "ruleLevel" : "field",
          "message" : "仅支持0-100的数字",
          "fieldKey" : "cust_support_num",
          "fieldName" : "供养人数",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "0",
            "max" : "100"
          }
        } ],
        "cust_license_num_invalid" : [ ],
        "loanasseth_valuation" : [ {
          "ruleType" : "decimal",
          "ruleLevel" : "field",
          "message" : "请输入在0到100000000之间的数字，小数点后最多可输入两位",
          "fieldKey" : "loanasseth_valuation",
          "fieldName" : "房屋估值",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "0",
            "max" : "100000000",
            "digits" : "2"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanasseth_valuation",
          "fieldName" : "房屋估值",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanasseth_has",
            "operator" : "==",
            "value" : "1"
          } ],
          "detail" : null
        } ],
        "custjob_dept_name" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过15",
          "fieldKey" : "custjob_dept_name",
          "fieldName" : "所在部门/科室",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "15",
            "min" : "1"
          }
        } ],
        "loan_apply_daylyTerm" : [ {
          "ruleType" : "integer",
          "ruleLevel" : "field",
          "message" : "仅支持1-100的数字",
          "fieldKey" : "loan_apply_daylyTerm",
          "fieldName" : "借款期限",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "100"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loan_apply_daylyTerm",
          "fieldName" : "借款期限",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loan_apply_repaymentTypes",
            "operator" : "==",
            "value" : "3"
          } ],
          "detail" : null
        } ],
        "loanassethimg_month_certificate" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loanassethimg_month_certificate",
          "fieldName" : "近一个月房产查档证明",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loancarimg_back_interior" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_back_interior",
          "fieldName" : "后内饰照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loancarinfo_body_category_2" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarinfo_body_category_2",
          "fieldName" : "车身类别驱动",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loancarinfo_body_category_1",
            "operator" : "==",
            "value" : "0"
          } ],
          "detail" : null
        } ],
        "loancarinfo_body_category_1" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarinfo_body_category_1",
          "fieldName" : "车身类别",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarinfo_body_category_3" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarinfo_body_category_3",
          "fieldName" : "车身类别款式",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loancarinfo_body_category_1",
            "operator" : "==",
            "value" : "1"
          } ],
          "detail" : null
        } ],
        "loanofee_consulting" : [ {
          "ruleType" : "decimal",
          "ruleLevel" : "field",
          "message" : "请输入在0到100之间的数字，小数点后最多可输入两位",
          "fieldKey" : "loanofee_consulting",
          "fieldName" : "咨询费",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "0",
            "max" : "100",
            "digits" : "2"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanofee_consulting",
          "fieldName" : "咨询费",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanrebank_addr_province" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanrebank_addr_province",
          "fieldName" : "还款银行开户地省",
          "parent" : "loanrebank_addr",
          "condition" : null,
          "detail" : null
        } ],
        "loanapproval_repayment" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_repayment",
          "fieldName" : "还款方式",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loansecurity_name2" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过20",
          "fieldKey" : "loansecurity_name2",
          "fieldName" : "抵押物2",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "20",
            "min" : "1"
          }
        } ],
        "custfriend_mobile" : [ {
          "ruleType" : "phone",
          "ruleLevel" : "field",
          "message" : "请输入正确的手机号",
          "fieldKey" : "custfriend_mobile",
          "fieldName" : "移动电话",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loansecurity_name3" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过20",
          "fieldKey" : "loansecurity_name3",
          "fieldName" : "抵押物3",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "20",
            "min" : "1"
          }
        } ],
        "loansecurity_name4" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过20",
          "fieldKey" : "loansecurity_name4",
          "fieldName" : "抵押物4",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "20",
            "min" : "1"
          }
        } ],
        "loanrebank_addr_city" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanrebank_addr_city",
          "fieldName" : "还款银行开户地市",
          "parent" : "loanrebank_addr",
          "condition" : null,
          "detail" : null
        } ],
        "cust_live_addr_detail" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过30",
          "fieldKey" : "cust_live_addr_detail",
          "fieldName" : "现住址详细",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "30",
            "min" : "1"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "cust_live_addr_detail",
          "fieldName" : "现住址详细",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanapproval_daylyTerm" : [ {
          "ruleType" : "integer",
          "ruleLevel" : "field",
          "message" : "请输入1到100之间的数字",
          "fieldKey" : "loanapproval_daylyTerm",
          "fieldName" : "审批期限",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "100"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_daylyTerm",
          "fieldName" : "审批期限",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanapproval_repaymentTypes",
            "operator" : "==",
            "value" : "3"
          } ],
          "detail" : null
        } ],
        "custjob_salary_date" : [ {
          "ruleType" : "integer",
          "ruleLevel" : "field",
          "message" : "请输入在1到28之间",
          "fieldKey" : "custjob_salary_date",
          "fieldName" : "每月发薪日",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "custjob_identity",
            "operator" : "==",
            "value" : "1"
          } ],
          "detail" : {
            "min" : "1",
            "max" : "28"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "custjob_salary_date",
          "fieldName" : "每月发薪日",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "borrower2_license_num" : [ ],
        "loancarimg_business_insurance" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_business_insurance",
          "fieldName" : "商业险保单合同",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loan_mort_type" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loan_mort_type",
          "fieldName" : "抵押类型",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "cust_child_count" : [ {
          "ruleType" : "integer",
          "ruleLevel" : "field",
          "message" : "仅支持0-100的数字",
          "fieldKey" : "cust_child_count",
          "fieldName" : "子女数目",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "0",
            "max" : "100"
          }
        } ],
        "loanasseth_desc" : [ ],
        "loancar_driving_position" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancar_driving_position",
          "fieldName" : "驾驶位置",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loansecurity_name1" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过20",
          "fieldKey" : "loansecurity_name1",
          "fieldName" : "抵押物1",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "20",
            "min" : "1"
          }
        } ],
        "loancarimg_main_door" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_main_door",
          "fieldName" : "主驾门叶照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loancarrepair_lock_o" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loancarrepair_lock_o",
          "fieldName" : "暗锁打开方式",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarrepair_lock_o",
          "fieldName" : "暗锁打开方式",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loancarrepair_lock",
            "operator" : "==",
            "value" : "1"
          } ],
          "detail" : null
        } ],
        "loancar_num" : [ ],
        "loancarrepair_lock_p" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loancarrepair_lock_p",
          "fieldName" : "暗锁位置",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarrepair_lock_p",
          "fieldName" : "暗锁位置",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loancarrepair_lock",
            "operator" : "==",
            "value" : "1"
          } ],
          "detail" : null
        } ],
        "cust_mobile2" : [ {
          "ruleType" : "phone",
          "ruleLevel" : "field",
          "message" : "请输入正确的手机号",
          "fieldKey" : "cust_mobile2",
          "fieldName" : "手机号2",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanapproval_yearlyRate" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_yearlyRate",
          "fieldName" : "年化率",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanapproval_repaymentTypes",
            "operator" : "!=",
            "value" : "3"
          } ],
          "detail" : null
        } ],
        "borrower2_role" : [ ],
        "custfriend_other_mobile" : [ {
          "ruleType" : "phone",
          "ruleLevel" : "field",
          "message" : "请输入正确的手机号",
          "fieldKey" : "custfriend_other_mobile",
          "fieldName" : "移动电话",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanofee_repay_day" : [ {
          "ruleType" : "integer",
          "ruleLevel" : "field",
          "message" : "请输入在1到28之间的数字",
          "fieldKey" : "loanofee_repay_day",
          "fieldName" : "还款日",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "28"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanofee_repay_day",
          "fieldName" : "还款日",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanadvice_repaymentTypes",
            "operator" : "==",
            "value" : "2"
          } ],
          "detail" : null
        } ],
        "loanasseth_address_counties" : [ ],
        "loanapproval_daylyZHFee" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_daylyZHFee",
          "fieldName" : "日综合利率",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanapproval_repaymentTypes",
            "operator" : "==",
            "value" : "3"
          } ],
          "detail" : null
        } ],
        "loancontractimg_loan" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "loancontractimg_loan",
          "fieldName" : "借款合同",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancontractimg_loan",
          "fieldName" : "借款合同",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanofee_gpsservice" : [ {
          "ruleType" : "decimal",
          "ruleLevel" : "field",
          "message" : "请输入在0到100000000之间的数字，小数点后最多可输入两位",
          "fieldKey" : "loanofee_gpsservice",
          "fieldName" : "GPS服务费",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "0",
            "max" : "100000000",
            "digits" : "2"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanofee_gpsservice",
          "fieldName" : "GPS服务费",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarimg_main_drive" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_main_drive",
          "fieldName" : "主驾驶正照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loanadvice_daylyTerm" : [ {
          "ruleType" : "integer",
          "ruleLevel" : "field",
          "message" : "仅支持1-100的数字",
          "fieldKey" : "loan_apply_daylyTerm",
          "fieldName" : "建议期限",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "100"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanadvice_daylyTerm",
          "fieldName" : "建议借款期限",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanadvice_repaymentTypes",
            "operator" : "==",
            "value" : "3"
          } ],
          "detail" : null
        } ],
        "loanapproval_loan_term" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到40位字符",
          "fieldKey" : "loanapproval_loan_term",
          "fieldName" : "放款条件",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "40"
          }
        } ],
        "loanrebank_branch" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanrebank_branch",
          "fieldName" : "还款银行支行",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loansecurityimg_form" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "loansecurityimg_form",
          "fieldName" : "押品登记表",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loansecurityimg_form",
          "fieldName" : "押品登记表",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancar_car_color" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancar_car_color",
          "fieldName" : "车身颜色",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancar_car_bms_brand" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancar_car_bms_brand",
          "fieldName" : "车品牌",
          "parent" : "loancar_car_bms",
          "condition" : null,
          "detail" : null
        } ],
        "cust_live_addr_counties" : [ ],
        "borrower3_home_addr_detail" : [ ],
        "loancheckinfo_person" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过40",
          "fieldKey" : "loancheckinfo_person",
          "fieldName" : "个人资料",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "40",
            "min" : "1"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancheckinfo_person",
          "fieldName" : "个人资料",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "cust_house_type" : [ ],
        "custjob_income_month" : [ ],
        "custfriend_know_4" : [ ],
        "custfriend_know_2" : [ ],
        "loanadvice_repaymentTypes" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanadvice_repaymentTypes",
          "fieldName" : "建议还款方式",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custfriend_know_3" : [ ],
        "custfriend_know_0" : [ ],
        "custfriend_know_1" : [ ],
        "loanofee_park" : [ {
          "ruleType" : "decimal",
          "ruleLevel" : "field",
          "message" : "请输入在0到100000000之间的数字，小数点后最多可输入两位",
          "fieldKey" : "loanofee_park",
          "fieldName" : "停车费",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "0",
            "max" : "100000000",
            "digits" : "2"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanofee_park",
          "fieldName" : "停车费",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarrepair_accid_lvl" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarrepair_accid_lvl",
          "fieldName" : "整车事故大小",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loancarrepair_accident",
            "operator" : "==",
            "value" : "1"
          } ],
          "detail" : null
        } ],
        "loandebit_date" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loandebit_date",
          "fieldName" : "放款日期",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancar_frame_number" : [ {
          "ruleType" : "regexp",
          "ruleLevel" : "field",
          "message" : "请输入正确车架号",
          "fieldKey" : "loancar_frame_number",
          "fieldName" : "车架号",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "regexp" : "^[a-zA-Z0-9]{17}$"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancar_frame_number",
          "fieldName" : "车架号",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarimg_front_glass" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_front_glass",
          "fieldName" : "前挡风玻璃码照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loancontractimg_car" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "loancontractimg_car",
          "fieldName" : "汽车抵押合同",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancontractimg_car",
          "fieldName" : "汽车抵押合同",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarassessimg_pic" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "loancarassessimg_pic",
          "fieldName" : "评估单",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarassessimg_pic",
          "fieldName" : "评估单",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "borrower2_home_addr_detail" : [ ],
        "loanasseth_address_province" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanasseth_address_province",
          "fieldName" : "房产地址省",
          "parent" : "loanasseth_address",
          "condition" : [ {
            "fieldKey" : "loanasseth_has",
            "operator" : "==",
            "value" : "1"
          } ],
          "detail" : null
        } ],
        "loanadvice_supportFirstPay" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanadvice_supportFirstPay",
          "fieldName" : "建议首还款支付方式",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanasseth_address" : [ ],
        "borrower3_job" : [ ],
        "custearn_security_fund" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "custearn_security_fund",
          "fieldName" : "社保/公积金流水",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loancarinfo_procedure" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarinfo_procedure",
          "fieldName" : "已办理手续",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loan_has" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loan_has",
          "fieldName" : "是否有共同借款人",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "borrower2_home_addr_province" : [ ],
        "custjob_identity" : [ ],
        "custearn_business_licence" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "custearn_business_licence",
          "fieldName" : "营业执照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loancar_purchase_date" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancar_purchase_date",
          "fieldName" : "购车日期",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancheckinfo_finance" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过40",
          "fieldKey" : "loancheckinfo_finance",
          "fieldName" : "财务分析",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "40",
            "min" : "1"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancheckinfo_finance",
          "fieldName" : "财务分析",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancarinfo_mileage" : [ {
          "ruleType" : "integer",
          "ruleLevel" : "field",
          "message" : "请输入在1到2000000之间的整数",
          "fieldKey" : "loancarinfo_mileage",
          "fieldName" : "表里程数",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "2000000"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarinfo_mileage",
          "fieldName" : "表里程数",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanapproval_wyFee" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_wyFee",
          "fieldName" : "提前还款违约率",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "cust_regist_addr_counties" : [ ],
        "loanbank_addr" : [ ],
        "loancarimg_back_box" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_back_box",
          "fieldName" : "后尾箱照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "loancarimg_nameplate" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_nameplate",
          "fieldName" : "铭牌照",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        } ],
        "cust_live_addr_province" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "cust_live_addr_province",
          "fieldName" : "现住址省",
          "parent" : "cust_live_addr",
          "condition" : null,
          "detail" : null
        } ],
        "loan_usage_other" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "长度不能超过40",
          "fieldKey" : "loan_usage_other",
          "fieldName" : "其他",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "max" : "40",
            "min" : "1"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loan_usage_other",
          "fieldName" : "其他",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loan_usage",
            "operator" : "==",
            "value" : "8"
          } ],
          "detail" : null
        } ],
        "loandebit_mode" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loandebit_mode",
          "fieldName" : "放款方式",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "cust_education" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "cust_education",
          "fieldName" : "最高学历",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loan_mortgage_user" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loan_mortgage_user",
          "fieldName" : "抵押权人",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanadvice_loan" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入0到100位字符",
          "fieldKey" : "loanadvice_loan",
          "fieldName" : "放款建议",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "0",
            "max" : "100"
          }
        } ],
        "borrower2_home_addr" : [ ],
        "loancarrepair_info" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarrepair_info",
          "fieldName" : "维修情况",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancar_car_bms_series" : [ ],
        "custfriend_friend_mobile" : [ {
          "ruleType" : "phone",
          "ruleLevel" : "field",
          "message" : "请输入正确的手机号",
          "fieldKey" : "custfriend_friend_mobile",
          "fieldName" : "移动电话",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custjob_industry1" : [ ],
        "custjob_company_addr_counties" : [ ],
        "loancheckph_company" : [ {
          "ruleType" : "length",
          "ruleLevel" : "field",
          "message" : "请输入1到20位字符",
          "fieldKey" : "loancheckph_company",
          "fieldName" : "单位电话",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "1",
            "max" : "20"
          }
        } ],
        "loandebit_platform" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loandebit_platform",
          "fieldName" : "放款平台",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "cust_regist_addr_province" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "cust_regist_addr_province",
          "fieldName" : "户口所在地省",
          "parent" : "cust_regist_addr",
          "condition" : null,
          "detail" : null
        } ],
        "loanasseth_ownership" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanasseth_ownership",
          "fieldName" : "房产所有权",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanasseth_has",
            "operator" : "==",
            "value" : "1"
          } ],
          "detail" : null
        } ],
        "loancarimg_drive_license_fu" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "请上传jpg png格式的文件",
          "fieldKey" : "loancarimg_drive_license_fu",
          "fieldName" : "行驶证副页",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancarimg_drive_license_fu",
          "fieldName" : "行驶证副页",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanapproval_limit" : [ {
          "ruleType" : "decimal",
          "ruleLevel" : "field",
          "message" : "请输入在0到100000000之间的数字，小数点后最多可输入两位",
          "fieldKey" : "loanapproval_limit",
          "fieldName" : "审批金额",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "min" : "0",
            "max" : "100000000",
            "digits" : "2"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_limit",
          "fieldName" : "审批金额",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loancontractimg_transfer" : [ {
          "ruleType" : "file",
          "ruleLevel" : "field",
          "message" : "只能上传后缀为jpg png的文件",
          "fieldKey" : "loancontractimg_transfer",
          "fieldName" : "车辆转让协议",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "maxSize" : "104857600",
            "extension" : "jpg,jpeg,png",
            "type" : "image/jpg,image/jpeg,image/png"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loancontractimg_transfer",
          "fieldName" : "车辆转让协议",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "custjob_entry_time" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "custjob_entry_time",
          "fieldName" : "入职时间",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ],
        "loanapproval_monthlyTerm" : [ {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanapproval_monthlyTerm",
          "fieldName" : "审批期限",
          "parent" : null,
          "condition" : [ {
            "fieldKey" : "loanapproval_repaymentTypes",
            "operator" : "!=",
            "value" : "3"
          } ],
          "detail" : null
        } ],
        "loanrebank_account_no" : [ {
          "ruleType" : "regexp",
          "ruleLevel" : "field",
          "message" : "请输入正确银行卡号",
          "fieldKey" : "loanrebank_account_no",
          "fieldName" : "还款银行账号",
          "parent" : null,
          "condition" : null,
          "detail" : {
            "regexp" : "^\\d{16}|\\d{19}$"
          }
        }, {
          "ruleType" : "notEmpty",
          "ruleLevel" : "field",
          "message" : "必填",
          "fieldKey" : "loanrebank_account_no",
          "fieldName" : "还款银行账号",
          "parent" : null,
          "condition" : null,
          "detail" : null
        } ]
      }
    }
  }
  var testOptionData = {
    "status" : 1,
    "message" : "成功",
    "data" : [ {
      "id" : "065e33d133ce11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "一次性购买",
      "displayName" : "购买方式",
      "dicType" : "152",
      "dicStatus" : true,
      "description" : null,
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "066053a233ce11e783df0800270c7d97",
      "dicKey" : "2",
      "dicValue" : "按揭",
      "displayName" : "购买方式",
      "dicType" : "152",
      "dicStatus" : true,
      "description" : null,
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "0662e32033ce11e783df0800270c7d97",
      "dicKey" : "3",
      "dicValue" : "自建",
      "displayName" : "购买方式",
      "dicType" : "152",
      "dicStatus" : true,
      "description" : null,
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c70695a315f11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "厅局级及以上",
      "displayName" : "职称",
      "dicType" : "148",
      "dicStatus" : true,
      "description" : "职称",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c732549315f11e783df0800270c7d97",
      "dicKey" : "2",
      "dicValue" : "处级",
      "displayName" : "职称",
      "dicType" : "148",
      "dicStatus" : true,
      "description" : "职称",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c754245315f11e783df0800270c7d97",
      "dicKey" : "3",
      "dicValue" : "科级",
      "displayName" : "职称",
      "dicType" : "148",
      "dicStatus" : true,
      "description" : "职称",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c77b967315f11e783df0800270c7d97",
      "dicKey" : "4",
      "dicValue" : "一般干部",
      "displayName" : "职称",
      "dicType" : "148",
      "dicStatus" : true,
      "description" : "职称",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c7a8d54315f11e783df0800270c7d97",
      "dicKey" : "5",
      "dicValue" : "总经理级",
      "displayName" : "职称",
      "dicType" : "148",
      "dicStatus" : true,
      "description" : "职称",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c7d3177315f11e783df0800270c7d97",
      "dicKey" : "6",
      "dicValue" : "部门经理级",
      "displayName" : "职称",
      "dicType" : "148",
      "dicStatus" : true,
      "description" : "职称",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c7f8e64315f11e783df0800270c7d97",
      "dicKey" : "7",
      "dicValue" : "职员",
      "displayName" : "职称",
      "dicType" : "148",
      "dicStatus" : true,
      "description" : "职称",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c820e90315f11e783df0800270c7d97",
      "dicKey" : "8",
      "dicValue" : "其他",
      "displayName" : "职称",
      "dicType" : "148",
      "dicStatus" : true,
      "description" : "职称",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c846a0c315f11e783df0800270c7d97",
      "dicKey" : "A1",
      "dicValue" : "A1-大型客车",
      "displayName" : "车辆类型",
      "dicType" : "114",
      "dicStatus" : true,
      "description" : "大型客车",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c86fa56315f11e783df0800270c7d97",
      "dicKey" : "A2",
      "dicValue" : "A2-牵引车",
      "displayName" : "车辆类型",
      "dicType" : "114",
      "dicStatus" : true,
      "description" : "牵引车",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c89654f315f11e783df0800270c7d97",
      "dicKey" : "A3",
      "dicValue" : "A3-城市公交车",
      "displayName" : "车辆类型",
      "dicType" : "114",
      "dicStatus" : true,
      "description" : "城市公交车",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c8b91e1315f11e783df0800270c7d97",
      "dicKey" : "B1",
      "dicValue" : "B1-中型客车",
      "displayName" : "车辆类型",
      "dicType" : "114",
      "dicStatus" : true,
      "description" : "中型客车",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c8d7f0a315f11e783df0800270c7d97",
      "dicKey" : "B2",
      "dicValue" : "B2-大型货车",
      "displayName" : "车辆类型",
      "dicType" : "114",
      "dicStatus" : true,
      "description" : "大型货车",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c8fc1a4315f11e783df0800270c7d97",
      "dicKey" : "C1",
      "dicValue" : "C1-小型汽车",
      "displayName" : "车辆类型",
      "dicType" : "114",
      "dicStatus" : true,
      "description" : "小型汽车",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c91f2f5315f11e783df0800270c7d97",
      "dicKey" : "C2",
      "dicValue" : "C2-小型自动挡汽车",
      "displayName" : "车辆类型",
      "dicType" : "114",
      "dicStatus" : true,
      "description" : "小型自动挡汽车",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c96aef6315f11e783df0800270c7d97",
      "dicKey" : "2",
      "dicValue" : "教育支出",
      "displayName" : "借款用途",
      "dicType" : "120",
      "dicStatus" : true,
      "description" : "教育支出",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c9918ea315f11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "自建房",
      "displayName" : "房产类型",
      "dicType" : "121",
      "dicStatus" : true,
      "description" : "自建房",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c9b8c9b315f11e783df0800270c7d97",
      "dicKey" : "2",
      "dicValue" : "单位房",
      "displayName" : "房产类型",
      "dicType" : "121",
      "dicStatus" : true,
      "description" : "单位房",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1c9de40a315f11e783df0800270c7d97",
      "dicKey" : "0",
      "dicValue" : "本人",
      "displayName" : "房产所有权",
      "dicType" : "122",
      "dicStatus" : true,
      "description" : "本人",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1ca05caa315f11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "与配偶共有",
      "displayName" : "房产所有权",
      "dicType" : "122",
      "dicStatus" : true,
      "description" : "与配偶共有",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1ca2658c315f11e783df0800270c7d97",
      "dicKey" : "2",
      "dicValue" : "有其他人共有",
      "displayName" : "房产所有权",
      "dicType" : "122",
      "dicStatus" : true,
      "description" : "有其他人共有",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1cb0f367315f11e783df0800270c7d97",
      "dicKey" : "3",
      "dicValue" : "医疗支出",
      "displayName" : "借款用途",
      "dicType" : "120",
      "dicStatus" : true,
      "description" : "医疗支出",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1cc9d9c1315f11e783df0800270c7d97",
      "dicKey" : "4",
      "dicValue" : "提高生活质量",
      "displayName" : "借款用途",
      "dicType" : "120",
      "dicStatus" : true,
      "description" : "提高生活质量",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1ce1b795315f11e783df0800270c7d97",
      "dicKey" : "5",
      "dicValue" : "购物",
      "displayName" : "借款用途",
      "dicType" : "120",
      "dicStatus" : true,
      "description" : "购物",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1cf9c328315f11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "押证押车",
      "displayName" : "抵押类型",
      "dicType" : "103",
      "dicStatus" : true,
      "description" : "抵押类型",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1d126b00315f11e783df0800270c7d97",
      "dicKey" : "2",
      "dicValue" : "押证不押车",
      "displayName" : "抵押类型",
      "dicType" : "103",
      "dicStatus" : true,
      "description" : "抵押类型",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1d2d0791315f11e783df0800270c7d97",
      "dicKey" : "3",
      "dicValue" : "押车不押证",
      "displayName" : "抵押类型",
      "dicType" : "103",
      "dicStatus" : true,
      "description" : "抵押类型",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1d487575315f11e783df0800270c7d97",
      "dicKey" : "6",
      "dicValue" : "生意往来",
      "displayName" : "借款用途",
      "dicType" : "120",
      "dicStatus" : true,
      "description" : "生意往来",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1d611c69315f11e783df0800270c7d97",
      "dicKey" : "8",
      "dicValue" : "其他",
      "displayName" : "借款用途",
      "dicType" : "120",
      "dicStatus" : true,
      "description" : "其他",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1d7c085c315f11e783df0800270c7d97",
      "dicKey" : "7",
      "dicValue" : "保险",
      "displayName" : "借款用途",
      "dicType" : "120",
      "dicStatus" : true,
      "description" : "保险",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1d8e1d07315f11e783df0800270c7d97",
      "dicKey" : "0",
      "dicValue" : "未婚",
      "displayName" : "婚姻状况",
      "dicType" : "105",
      "dicStatus" : true,
      "description" : "未婚",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1d90830d315f11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "已婚",
      "displayName" : "婚姻状况",
      "dicType" : "105",
      "dicStatus" : true,
      "description" : "已婚",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1d92fd00315f11e783df0800270c7d97",
      "dicKey" : "2",
      "dicValue" : "离异",
      "displayName" : "婚姻状况",
      "dicType" : "105",
      "dicStatus" : true,
      "description" : "离异",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1d952061315f11e783df0800270c7d97",
      "dicKey" : "3",
      "dicValue" : "再婚",
      "displayName" : "婚姻状况",
      "dicType" : "105",
      "dicStatus" : true,
      "description" : "再婚",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1d977445315f11e783df0800270c7d97",
      "dicKey" : "4",
      "dicValue" : "丧偶",
      "displayName" : "婚姻状况",
      "dicType" : "105",
      "dicStatus" : true,
      "description" : "丧偶",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1d99eb2e315f11e783df0800270c7d97",
      "dicKey" : "0",
      "dicValue" : "高中以下",
      "displayName" : "最高学历",
      "dicType" : "106",
      "dicStatus" : true,
      "description" : "高中以下",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1d9bfa71315f11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "高中",
      "displayName" : "最高学历",
      "dicType" : "106",
      "dicStatus" : true,
      "description" : "高中",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1d9dda02315f11e783df0800270c7d97",
      "dicKey" : "2",
      "dicValue" : "中专",
      "displayName" : "最高学历",
      "dicType" : "106",
      "dicStatus" : true,
      "description" : "中专",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1d9fe437315f11e783df0800270c7d97",
      "dicKey" : "3",
      "dicValue" : "大专",
      "displayName" : "最高学历",
      "dicType" : "106",
      "dicStatus" : true,
      "description" : "大专",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1da26616315f11e783df0800270c7d97",
      "dicKey" : "4",
      "dicValue" : "本科",
      "displayName" : "最高学历",
      "dicType" : "106",
      "dicStatus" : true,
      "description" : "本科",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1da4910d315f11e783df0800270c7d97",
      "dicKey" : "5",
      "dicValue" : "硕士及以上学历",
      "displayName" : "最高学历",
      "dicType" : "106",
      "dicStatus" : true,
      "description" : "硕士及以上学历",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1da8aab8315f11e783df0800270c7d97",
      "dicKey" : "0",
      "dicValue" : "自购商业按揭房",
      "displayName" : "现住址类别",
      "dicType" : "107",
      "dicStatus" : true,
      "description" : "自购商业按揭房",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1daa84db315f11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "自购无按揭房",
      "displayName" : "现住址类别",
      "dicType" : "107",
      "dicStatus" : true,
      "description" : "自购无按揭房",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1dad2e3a315f11e783df0800270c7d97",
      "dicKey" : "2",
      "dicValue" : "自购公积金按揭房",
      "displayName" : "现住址类别",
      "dicType" : "107",
      "dicStatus" : true,
      "description" : "自购公积金按揭房",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1daff929315f11e783df0800270c7d97",
      "dicKey" : "3",
      "dicValue" : "自建房",
      "displayName" : "现住址类别",
      "dicType" : "107",
      "dicStatus" : true,
      "description" : "自建房",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1db1fff4315f11e783df0800270c7d97",
      "dicKey" : "4",
      "dicValue" : "租用",
      "displayName" : "现住址类别",
      "dicType" : "107",
      "dicStatus" : true,
      "description" : "租用",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1db42d19315f11e783df0800270c7d97",
      "dicKey" : "5",
      "dicValue" : "亲属住房",
      "displayName" : "现住址类别",
      "dicType" : "107",
      "dicStatus" : true,
      "description" : "亲属住房",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1db65f7d315f11e783df0800270c7d97",
      "dicKey" : "6",
      "dicValue" : "单位住房",
      "displayName" : "现住址类别",
      "dicType" : "107",
      "dicStatus" : true,
      "description" : "单位住房",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1db8c5a1315f11e783df0800270c7d97",
      "dicKey" : "0",
      "dicValue" : "机关事业",
      "displayName" : "单位性质",
      "dicType" : "108",
      "dicStatus" : true,
      "description" : "机关事业",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1dbb3f23315f11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "国有股份",
      "displayName" : "单位性质",
      "dicType" : "108",
      "dicStatus" : true,
      "description" : "国有股份",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1dbdfd16315f11e783df0800270c7d97",
      "dicKey" : "2",
      "dicValue" : "外贸",
      "displayName" : "单位性质",
      "dicType" : "108",
      "dicStatus" : true,
      "description" : "外贸",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1dc056a4315f11e783df0800270c7d97",
      "dicKey" : "3",
      "dicValue" : "民营",
      "displayName" : "单位性质",
      "dicType" : "108",
      "dicStatus" : true,
      "description" : "民营",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1dc2c5e9315f11e783df0800270c7d97",
      "dicKey" : "4",
      "dicValue" : "合资",
      "displayName" : "单位性质",
      "dicType" : "108",
      "dicStatus" : true,
      "description" : "合资",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1dc53758315f11e783df0800270c7d97",
      "dicKey" : "5",
      "dicValue" : "个体",
      "displayName" : "单位性质",
      "dicType" : "108",
      "dicStatus" : true,
      "description" : "个体",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1dc75ed9315f11e783df0800270c7d97",
      "dicKey" : "6",
      "dicValue" : "社会团体",
      "displayName" : "单位性质",
      "dicType" : "108",
      "dicStatus" : true,
      "description" : "社会团体",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1dc9719c315f11e783df0800270c7d97",
      "dicKey" : "0",
      "dicValue" : "网银",
      "displayName" : "工资发放形式",
      "dicType" : "109",
      "dicStatus" : true,
      "description" : "网银",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1dcb63c6315f11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "现金",
      "displayName" : "工资发放形式",
      "dicType" : "109",
      "dicStatus" : true,
      "description" : "现金",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1dcda191315f11e783df0800270c7d97",
      "dicKey" : "2",
      "dicValue" : "网银+现金",
      "displayName" : "工资发放形式",
      "dicType" : "109",
      "dicStatus" : true,
      "description" : "网银+现金",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1de5c10f315f11e783df0800270c7d97",
      "dicKey" : "0",
      "dicValue" : "个人",
      "displayName" : "客户类型",
      "dicType" : "110",
      "dicStatus" : true,
      "description" : "个人",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1de8a036315f11e783df0800270c7d97",
      "dicKey" : "0",
      "dicValue" : "白",
      "displayName" : "车身颜色",
      "dicType" : "115",
      "dicStatus" : true,
      "description" : "白",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1decaeb6315f11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "灰",
      "displayName" : "车身颜色",
      "dicType" : "115",
      "dicStatus" : true,
      "description" : "灰",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1deef246315f11e783df0800270c7d97",
      "dicKey" : "2",
      "dicValue" : "黄",
      "displayName" : "车身颜色",
      "dicType" : "115",
      "dicStatus" : true,
      "description" : "黄",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1df132fc315f11e783df0800270c7d97",
      "dicKey" : "3",
      "dicValue" : "粉",
      "displayName" : "车身颜色",
      "dicType" : "115",
      "dicStatus" : true,
      "description" : "粉",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1df3763b315f11e783df0800270c7d97",
      "dicKey" : "4",
      "dicValue" : "红",
      "displayName" : "车身颜色",
      "dicType" : "115",
      "dicStatus" : true,
      "description" : "红",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1df5d436315f11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "企业",
      "displayName" : "客户类型",
      "dicType" : "110",
      "dicStatus" : true,
      "description" : "企业",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1df82645315f11e783df0800270c7d97",
      "dicKey" : "5",
      "dicValue" : "紫",
      "displayName" : "车身颜色",
      "dicType" : "115",
      "dicStatus" : true,
      "description" : "紫",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1dfa3137315f11e783df0800270c7d97",
      "dicKey" : "6",
      "dicValue" : "绿",
      "displayName" : "车身颜色",
      "dicType" : "115",
      "dicStatus" : true,
      "description" : "绿",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1dfc3fc4315f11e783df0800270c7d97",
      "dicKey" : "7",
      "dicValue" : "蓝",
      "displayName" : "车身颜色",
      "dicType" : "115",
      "dicStatus" : true,
      "description" : "蓝",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1dfe3a2d315f11e783df0800270c7d97",
      "dicKey" : "8",
      "dicValue" : "棕",
      "displayName" : "车身颜色",
      "dicType" : "115",
      "dicStatus" : true,
      "description" : "棕",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e0062b9315f11e783df0800270c7d97",
      "dicKey" : "9",
      "dicValue" : "黑",
      "displayName" : "车身颜色",
      "dicType" : "115",
      "dicStatus" : true,
      "description" : "黑",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e029556315f11e783df0800270c7d97",
      "dicKey" : "10",
      "dicValue" : "银",
      "displayName" : "车身颜色",
      "dicType" : "115",
      "dicStatus" : true,
      "description" : "银",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e04de52315f11e783df0800270c7d97",
      "dicKey" : "11",
      "dicValue" : "多彩",
      "displayName" : "车身颜色",
      "dicType" : "115",
      "dicStatus" : true,
      "description" : "多彩",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e0744dc315f11e783df0800270c7d97",
      "dicKey" : "0",
      "dicValue" : "汽油",
      "displayName" : "燃料种类",
      "dicType" : "116",
      "dicStatus" : true,
      "description" : "汽油",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e0955b6315f11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "柴油",
      "displayName" : "燃料种类",
      "dicType" : "116",
      "dicStatus" : true,
      "description" : "柴油",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e0b92ba315f11e783df0800270c7d97",
      "dicKey" : "2",
      "dicValue" : "油/电混合",
      "displayName" : "燃料种类",
      "dicType" : "116",
      "dicStatus" : true,
      "description" : "油/电混合",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e0df44b315f11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "日常生活消费",
      "displayName" : "借款用途",
      "dicType" : "120",
      "dicStatus" : true,
      "description" : "日常生活消费",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e10241b315f11e783df0800270c7d97",
      "dicKey" : "3",
      "dicValue" : "电动",
      "displayName" : "燃料种类",
      "dicType" : "116",
      "dicStatus" : true,
      "description" : "电动",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e12f446315f11e783df0800270c7d97",
      "dicKey" : "4",
      "dicValue" : "油/气混合",
      "displayName" : "燃料种类",
      "dicType" : "116",
      "dicStatus" : true,
      "description" : "油/气混合",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e157389315f11e783df0800270c7d97",
      "dicKey" : "5",
      "dicValue" : "天然气",
      "displayName" : "燃料种类",
      "dicType" : "116",
      "dicStatus" : true,
      "description" : "天然气",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e1801ed315f11e783df0800270c7d97",
      "dicKey" : "0",
      "dicValue" : "左边",
      "displayName" : "驾驶位置",
      "dicType" : "117",
      "dicStatus" : true,
      "description" : "左边",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e1aa400315f11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "右边",
      "displayName" : "驾驶位置",
      "dicType" : "117",
      "dicStatus" : true,
      "description" : "右边",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e1d22de315f11e783df0800270c7d97",
      "dicKey" : "0",
      "dicValue" : "个人名下",
      "displayName" : "车辆归属",
      "dicType" : "118",
      "dicStatus" : true,
      "description" : "个人名下",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e1f5a9d315f11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "企业名下",
      "displayName" : "车辆归属",
      "dicType" : "118",
      "dicStatus" : true,
      "description" : "企业名下",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e21c009315f11e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "是",
      "displayName" : "是否有房产",
      "dicType" : "119",
      "dicStatus" : true,
      "description" : "有房产",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e23ee5e315f11e783df0800270c7d97",
      "dicKey" : "0",
      "dicValue" : "否",
      "displayName" : "是否有房产",
      "dicType" : "119",
      "dicStatus" : true,
      "description" : "无房产",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "1e26424c315f11e783df0800270c7d97",
      "dicKey" : "0",
      "dicValue" : "商品房",
      "displayName" : "房产类型",
      "dicType" : "121",
      "dicStatus" : true,
      "description" : "商品房",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "6997006c348511e7b4980800270c7d97",
      "dicKey" : "1",
      "dicValue" : "丈夫",
      "displayName" : "与申请人关系",
      "dicType" : "155",
      "dicStatus" : true,
      "description" : "丈夫",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "6999338f348511e7b4980800270c7d97",
      "dicKey" : "2",
      "dicValue" : "妻子",
      "displayName" : "与申请人关系",
      "dicType" : "155",
      "dicStatus" : true,
      "description" : "妻子",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "88262fd1316311e783df0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "受薪人士",
      "displayName" : "职业身份",
      "dicType" : "151",
      "dicStatus" : true,
      "description" : null,
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "8828df7f316311e783df0800270c7d97",
      "dicKey" : "2",
      "dicValue" : "自雇人士",
      "displayName" : "职业身份",
      "dicType" : "151",
      "dicStatus" : true,
      "description" : null,
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "882b6e81316311e783df0800270c7d97",
      "dicKey" : "3",
      "dicValue" : "企业股东",
      "displayName" : "职业身份",
      "dicType" : "151",
      "dicStatus" : true,
      "description" : null,
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "b79ba940345b11e7b4980800270c7d97",
      "dicKey" : "4",
      "dicValue" : "车辆公证",
      "displayName" : "抵押类型",
      "dicType" : "103",
      "dicStatus" : true,
      "description" : null,
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "b79d90c2345b11e7b4980800270c7d97",
      "dicKey" : "5",
      "dicValue" : "车辆过户",
      "displayName" : "抵押类型",
      "dicType" : "103",
      "dicStatus" : true,
      "description" : null,
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "b9915914345811e7b4980800270c7d97",
      "dicKey" : "1",
      "dicValue" : "按揭",
      "displayName" : "当前房产状态",
      "dicType" : "153",
      "dicStatus" : true,
      "description" : null,
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "b996318a345811e7b4980800270c7d97",
      "dicKey" : "2",
      "dicValue" : "非按揭",
      "displayName" : "当前房产状态",
      "dicType" : "153",
      "dicStatus" : true,
      "description" : null,
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "c39ed73c348311e7b4980800270c7d97",
      "dicKey" : "1",
      "dicValue" : "主借款人",
      "displayName" : "共同借款人角色",
      "dicType" : "154",
      "dicStatus" : true,
      "description" : "主借款人",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "c3a05c42348311e7b4980800270c7d97",
      "dicKey" : "2",
      "dicValue" : "从借款人",
      "displayName" : "共同借款人角色",
      "dicType" : "154",
      "dicStatus" : true,
      "description" : "从借款人",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f47e37d53a0511e78f9b0800270c7d97",
      "dicKey" : "0",
      "dicValue" : "配偶",
      "displayName" : "联系人关系",
      "dicType" : "111",
      "dicStatus" : true,
      "description" : "配偶",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f4801a1c3a0511e78f9b0800270c7d97",
      "dicKey" : "1",
      "dicValue" : "父亲",
      "displayName" : "联系人关系",
      "dicType" : "111",
      "dicStatus" : true,
      "description" : "父亲",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f481f3853a0511e78f9b0800270c7d97",
      "dicKey" : "2",
      "dicValue" : "母亲",
      "displayName" : "联系人关系",
      "dicType" : "111",
      "dicStatus" : true,
      "description" : "母亲",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f48404ad3a0511e78f9b0800270c7d97",
      "dicKey" : "3",
      "dicValue" : "儿子",
      "displayName" : "联系人关系",
      "dicType" : "111",
      "dicStatus" : true,
      "description" : "儿子",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f4862ca73a0511e78f9b0800270c7d97",
      "dicKey" : "4",
      "dicValue" : "女儿",
      "displayName" : "联系人关系",
      "dicType" : "111",
      "dicStatus" : true,
      "description" : "女儿",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f490ff5c3a0511e78f9b0800270c7d97",
      "dicKey" : "5",
      "dicValue" : "姐妹",
      "displayName" : "联系人关系",
      "dicType" : "111",
      "dicStatus" : true,
      "description" : "姐妹",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f495e96b3a0511e78f9b0800270c7d97",
      "dicKey" : "6",
      "dicValue" : "兄弟",
      "displayName" : "联系人关系",
      "dicType" : "111",
      "dicStatus" : true,
      "description" : "兄弟",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f49868d43a0511e78f9b0800270c7d97",
      "dicKey" : "7",
      "dicValue" : "表亲",
      "displayName" : "联系人关系",
      "dicType" : "111",
      "dicStatus" : true,
      "description" : "表亲",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f49ada6b3a0511e78f9b0800270c7d97",
      "dicKey" : "8",
      "dicValue" : "同学",
      "displayName" : "联系人关系",
      "dicType" : "111",
      "dicStatus" : true,
      "description" : "同学",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f49d419b3a0511e78f9b0800270c7d97",
      "dicKey" : "9",
      "dicValue" : "同事",
      "displayName" : "联系人关系",
      "dicType" : "111",
      "dicStatus" : true,
      "description" : "同事",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f49fa7b23a0511e78f9b0800270c7d97",
      "dicKey" : "10",
      "dicValue" : "朋友",
      "displayName" : "联系人关系",
      "dicType" : "111",
      "dicStatus" : true,
      "description" : "朋友",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f4a1c9973a0511e78f9b0800270c7d97",
      "dicKey" : "11",
      "dicValue" : "其他",
      "displayName" : "联系人关系",
      "dicType" : "111",
      "dicStatus" : true,
      "description" : "其他",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f95b2b09345d11e7b4980800270c7d97",
      "dicKey" : "1",
      "dicValue" : "个人抵押",
      "displayName" : "借款形式",
      "dicType" : "149",
      "dicStatus" : true,
      "description" : "个人抵押",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f95d796a345d11e7b4980800270c7d97",
      "dicKey" : "2",
      "dicValue" : "个人信用",
      "displayName" : "借款形式",
      "dicType" : "149",
      "dicStatus" : true,
      "description" : "个人信用",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f9643f22345d11e7b4980800270c7d97",
      "dicKey" : "3",
      "dicValue" : "个人分期",
      "displayName" : "借款形式",
      "dicType" : "149",
      "dicStatus" : true,
      "description" : "个人分期",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f96608ce345d11e7b4980800270c7d97",
      "dicKey" : "4",
      "dicValue" : "企业抵押",
      "displayName" : "借款形式",
      "dicType" : "149",
      "dicStatus" : true,
      "description" : "企业抵押",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f9688ae6345d11e7b4980800270c7d97",
      "dicKey" : "5",
      "dicValue" : "企业信用",
      "displayName" : "借款形式",
      "dicType" : "149",
      "dicStatus" : true,
      "description" : "企业信用",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f96ade4e345d11e7b4980800270c7d97",
      "dicKey" : "6",
      "dicValue" : "企业租赁",
      "displayName" : "借款形式",
      "dicType" : "149",
      "dicStatus" : true,
      "description" : "企业租赁",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f96ce70c345d11e7b4980800270c7d97",
      "dicKey" : "7",
      "dicValue" : "企业分期",
      "displayName" : "借款形式",
      "dicType" : "149",
      "dicStatus" : true,
      "description" : "企业分期",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    }, {
      "id" : "f97073e6345d11e7b4980800270c7d97",
      "dicKey" : "8",
      "dicValue" : "个人租赁",
      "displayName" : "借款形式",
      "dicType" : "149",
      "dicStatus" : true,
      "description" : "个人租赁",
      "deleted" : false,
      "productId" : "CYD",
      "corpId" : "1",
      "bpDefId" : "4d49b787315a11e783df0800270c7d97"
    } ]
  };
 /!* if(testdata.data.operations&&testdata.data.operations.length>0){
    testdata.data.layoutInfo.groups.push({
      "tabName": "审核意见",
      "tabList": [],
      "operations":true,
      "handle":true
    })
  };*!/
  cb({layoutInfo: testdata.data.layoutInfo,    buttonData: testdata.data.layoutInfo.buttons,    optionData: formatOptionData(testOptionData),    attrsData: testdata.data.attrs,    rulesData: testdata.data.checkrules,    operationsData: testdata.data.operations,    defaultHiddenData: testdata.data.defaultHidden  });return;
//todo 测试结束*/

  var all = {};
  //获取表单数据
  APIAjax(opts.formDataOpts, function (res) {
    var data = res.data;
    var layoutInfo = data.layoutInfo || {};
    if (queryView == 'true') {
      queryView = true;
    } else {
      queryView = false;
    }
    if (queryView) {
      if (layoutInfo.groups) {
        for (var index in layoutInfo.groups) {
          var item = layoutInfo.groups[index].tabList;
          item = formatLayoutData(item)
        }
        /*console.log(layoutInfo.groups)*/
      }
      all.view = true;
    }

    /*//主动添加审核意见tab
    if(data.operations&&data.operations.length>0){
        if(layoutInfo.groups){
          layoutInfo.groups.push({
            "tabName": "审核意见",
            "tabList": [],
            "operations":true,
            "handle":true
          })
        }
    }*/
    all.layoutInfo = layoutInfo;//表单数据
    all.attrsData = data.attrs;
    all.buttonData = layoutInfo.buttons;
    all.defaultHiddenData = data.defaultHidden || {};
    all.operationsData = data.operations;
    all.rulesData = data.checkrules;

    //获取表单填充数据
    var tempParams = [];
    for (var index in layoutInfo.groups) {
      var item = layoutInfo.groups[index].tabList;
      tempParams = tempParams.concat(getOptionDataParams(item))
    }
    var params = tempParams.join(',');
    $.extend(opts.optionDataOpts.data, all.defaultHiddenData);
    opts.optionDataOpts.data.type = params;
    opts.optionDataOpts.data.productId = all.defaultHiddenData.productId;
    APIAjax(opts.optionDataOpts, function (res) {
      var optionData = formatOptionData(res);
      all.optionData = optionData;
      cb(all)
    });

  })
}
//获取地址数据
export function getAddressData(api, cb) {
  APIAjax(api, function (res) {
    var data = res.data;
    cb(data);
  })
}
//获取车辆型号数据
export function getCar300Data(api, cb) {
  APIAjax(api, function (res) {
    var data = res.data;
    cb(data);
  })
}
//获取初审、高审数据
export function getExamineData(api, cb) {
/*  //TODO:高审和初审测试数据
   var res = {
   "status" : 1,
   "message" : "成功",
   "data" : {
   "bzjFee" : [ 6.0, 5.0 ],
   "wyFee" : [ 0.3, 0.01 ],
   "znjFee" : [ 0.1, 1.0 ],
   "eachTimes" : [ {
   "eachTimeName" : "1个月",
   "eachTime" : "M1"
   }, {
   "eachTimeName" : "2个月",
   "eachTime" : "M2"
   }, {
   "eachTimeName" : "3个月",
   "eachTime" : "M3"
   }, {
   "eachTimeName" : "6个月",
   "eachTime" : "M6"
   }, {
   "eachTimeName" : "12个月",
   "eachTime" : "M12"
   } ],
   "feeCaType" : "1",
   "feeRelated" : [ {
   "feeKey" : "HTJE",
   "feeName" : "合同金额",
   "partnerId" : "f271af76a62b4eea87dc98676d010f1f",
   "partnerRoleId" : "4"
   }, {
   "feeKey" : "JKRSSJE",
   "feeName" : "借款人实收金额",
   "partnerId" : null,
   "partnerRoleId" : null
   }, {
   "feeKey" : "ZXF",
   "feeName" : "咨询费",
   "partnerId" : "f271af76a62b4eea87dc98676d010f1f",
   "partnerRoleId" : "5"
   }, {
   "feeKey" : "YZHFY",
   "feeName" : "月综合费用",
   "partnerId" : "9fd73441894d4b908b81fe6a11435a66",
   "partnerRoleId" : "3"
   }, {
   "feeKey" : "YLX",
   "feeName" : "月利息",
   "partnerId" : "9fd73441894d4b908b81fe6a11435a66",
   "partnerRoleId" : "3"
   }, {
   "feeKey" : "YGLF",
   "feeName" : "月管理费",
   "partnerId" : "bf7ce93f57dc4f589b53c09be85bb8d5",
   "partnerRoleId" : "2"
   }, {
   "feeKey" : "BZJ",
   "feeName" : "保证金",
   "partnerId" : "f271af76a62b4eea87dc98676d010f1f",
   "partnerRoleId" : "4"
   }, {
   "feeKey" : "WYJ",
   "feeName" : "违约金",
   "partnerId" : "f271af76a62b4eea87dc98676d010f1f",
   "partnerRoleId" : "4"
   }, {
   "feeKey" : "DZJ",
   "feeName" : "滞纳金",
   "partnerId" : "f271af76a62b4eea87dc98676d010f1f",
   "partnerRoleId" : "4"
   }, {
   "feeKey" : "TCF",
   "feeName" : "停车费",
   "partnerId" : "f271af76a62b4eea87dc98676d010f1f",
   "partnerRoleId" : "4"
   }, {
   "feeKey" : "TCFF",
   "feeName" : "拖车费",
   "partnerId" : "f271af76a62b4eea87dc98676d010f1f",
   "partnerRoleId" : "4"
   }, {
   "feeKey" : "GPSAZF",
   "feeName" : "GPS安装费",
   "partnerId" : "f271af76a62b4eea87dc98676d010f1f",
   "partnerRoleId" : "4"
   }, {
   "feeKey" : "GPSFWF",
   "feeName" : "GPS服务费",
   "partnerId" : "f271af76a62b4eea87dc98676d010f1f",
   "partnerRoleId" : "4"
   } ],
   "gpsFee" : [ 100.0, 120.0, 1000.0 ],
   "gpsSerFee" : [ 100.0, 50.55, 1000.0 ],
   "monthlyFee" : [ {
   "monthlyRate" : "0.75",
   "term" : "M1",
   "yearlyRate" : "9.0",
   "daylyRate" : "0.02",
   "termText" : "1个月"
   }, {
   "monthlyRate" : "0.79",
   "term" : "M2",
   "yearlyRate" : "9.50",
   "daylyRate" : "0.03",
   "termText" : "2个月"
   }, {
   "monthlyRate" : "0.88",
   "term" : "M6",
   "yearlyRate" : "10.5",
   "daylyRate" : "0.03",
   "termText" : "6个月"
   }, {
   "monthlyRate" : "1.08",
   "term" : "M12",
   "yearlyRate" : "13.00",
   "daylyRate" : "0.04",
   "termText" : "12个月"
   }, {
   "monthlyRate" : "1.13",
   "term" : "M18",
   "yearlyRate" : "13.5",
   "daylyRate" : "0.04",
   "termText" : "18个月"
   }, {
   "monthlyRate" : "0.83",
   "term" : "M3",
   "yearlyRate" : "10.0",
   "daylyRate" : "0.03",
   "termText" : "3个月"
   } ],
   "daylyFee" : [ {
   "termStart" : "1",
   "termEnd" : "30",
   "daylyRate" : 0.02
   }, {
   "termStart" : "31",
   "termEnd" : "90",
   "daylyRate" : 0.05
   } ],
   "monthlyZHFee" : [ {
   "deptId" : "",
   "rate" : 2.51,
   "deptName" : "默认"
   }, {
   "deptId" : "c01efa4d8e79497d8df600943505482c",
   "rate" : 2.6,
   "deptName" : "下沙业务部"
   } ],
   "monthlyGLFee" : null,
   "daylyZHFee" : [ {
   "deptId" : "",
   "rate" : 0.2,
   "deptName" : "默认"
   }, {
   "deptId" : "c01efa4d8e79497d8df600943505482c",
   "rate" : 0.1,
   "deptName" : "下沙业务部"
   } ],
   "daylyGLFee" : null,
   "repaymentTypes" : [ {
   "repaymentType" : "1",
   "repaymentTypeName" : "等额等息",
   "supportFirstPay" : [ {
   "payName" : "期初支付",
   "payType" : "1"
   }, {
   "payName" : "期末支付",
   "payType" : "2"
   } ]
   }, {
   "repaymentType" : "2",
   "repaymentTypeName" : "先息后本",
   "supportFirstPay" : [ {
   "payName" : "期初支付",
   "payType" : "1"
   }, {
   "payName" : "期末支付",
   "payType" : "2"
   } ]
   }, {
   "repaymentType" : "3",
   "repaymentTypeName" : "一次性还清",
   "supportFirstPay" : [ {
   "payName" : "期末支付",
   "payType" : "2"
   } ]
   }, {
   "repaymentType" : "4",
   "repaymentTypeName" : "等额本金",
   "supportFirstPay" : [ {
   "payName" : "期初支付",
   "payType" : "1"
   }, {
   "payName" : "期末支付",
   "payType" : "2"
   } ]
   }, {
   "repaymentType" : "5",
   "repaymentTypeName" : "等额本息",
   "supportFirstPay" : [ {
   "payName" : "期初支付",
   "payType" : "1"
   }, {
   "payName" : "期末支付",
   "payType" : "2"
   } ]
   } ],
   "znjFeeCal" : "1",
   "monthlyFeeCal" : "1"
   }
   }
   var data=res.data;cb(data);return false;
//TODO:end*/
  APIAjax(api, function (res) {
    var data = res.data;
    cb(data);
  })
};
//获取p2p借款信息
export function getLoanData(api, cb) {
/*  //TODO:测试
  var res={
    "status" : 1,
    "message" : "成功",
    "data" : [ {
    "repaymentType" : "2",
    "repaymentTypeName" : "先息后本",
    "terms" : [ {
      "term" : "1",
      "termName" : "1个月"
    } ]
  } ]
  };
  var data = res.data;
  var tempData = {};
  //格式化下数据
  if (data && data.length > 0) {
    for (let key in data) {
      var item = data[key];
      var term = item.repaymentType;
      tempData[term] = item;
    }
  }
  cb(tempData);
//TODO:end*/

  APIAjax(api, function (res) {
    var data = res.data;
    var tempData = {};
    //格式化下数据
    if (data && data.length > 0) {
      for (let key in data) {
        var item = data[key];
        var term = item.repaymentType;
        tempData[term] = item;
      }
    }
    cb(tempData);
  })
}
export function getFeeData(api, cb) {
  APIAjax(api, function (res) {
    var data = res.data;
    cb(data);
  })
}
//获取合同
export function getContract(api, cb) {
  APIAjax(api, function (res) {
    var data = res.data;
    cb(data)
  })
}
//提交表单
export function submitFormData(api, cb) {
  APIAjax(api, cb)
}

// 获取编号
export function getGenNO(api, cb) {
  APIAjax(api, function (res) {
    var data = res.data;
    cb(data);
  })
}
//获取上传内容信息
export function getUploadFiles(api, cb) {
  APIAjax(api, function (res) {
    var data = res.data;
    var temp = {};
    data && $.each(data, function (key, item) {
      temp[item.resourceId] = item;
    });
    cb(temp)
  })
}
//获取特殊的select的option
export function getOptions2(api, cb) {
  APIAjax(api, function (res) {
    var data = res.data;
    cb(data)
  })
}
//获取征信数据
export function getCreditsData(api, cb) {
 /*   //TODO:征信数据
   var res = {
   "status" : 1,
   "message" : "成功",
   "data" : [
     {
       resource:'人法网',
       content:'测试了啊哈',
       url:'http://www.baidu.com'
     },
     {
       resource:'人法网',
       content:'测试了啊哈',
       url:'http://www.baidu.com'
     }
   ]
   }
   var data=res.data;cb(data);return false;
   //TODO:end*/
  APIAjax(api, function (res) {
    var data = res.data;
    cb(data);
  })
}

//获取后台数据
function APIAjax(api, cb) {
  var root = tools.www_root();
  var reqData = api.data;
  $.ajax({
    url: root + api.url,
    method: api.method || 'post',
    dataType: api.dataType || 'json',
    async: api.async || true,
    // contentType: api.dataType||"application/json",
    data: reqData,
    cache: api.cache || false,
    success: function (data) {
      if (data.status == 1) {
        cb(data)
      } else {
        $.alert(data.message);
      }
      api.success && api.success(data);
    },
    error: function () {
      $.alert('网络错误')
    },
    beforeSend: function () {
      api.beforeSend && api.beforeSend();
    },
    complete: function () {
      api.complete && api.complete();
    },
    timeout: api.timeout || 200000,

  });
}
// 转换option填充数据
function formatOptionData(res) {
  var data = res.data || [];
  var temp = {};
  for (var i in data) {
    var v = data[i];
    if (temp.hasOwnProperty(v.dicType)) {
      temp[v.dicType].push(v)
    } else {
      temp[v.dicType] = [];
      temp[v.dicType].push(v)
    }
  }
  /*data.forEach(function (v) {
   if(temp.hasOwnProperty(v.dicType)){
   temp[v.dicType].push(v)
   }else{
   temp[v.dicType]=[];
   temp[v.dicType].push(v)
   }
   });*/
  return temp;
}
//获取 表单填充数据的请求参数
function getOptionDataParams(data) {
  var params = [];
  var groups = data;
  for (var key in groups) {
    var v = groups[key];
    var editors = v.editors;
    if (editors) {
      for (var i in editors) {
        var item = editors[i];
        item.dataSource && !(item.dataSource in params) && params.push(item.dataSource);
        var extGroups = item.extEditors || item.extGroups || {}
        if (extGroups) {
          for (var j in extGroups) {
            var tempParams = getOptionDataParams(extGroups[j])
            params = tempParams.reduce((call, item)=> {
              !(item in call) && call.push(item);
              return call;
            }, params)
          }
        }
      }
    } else {
      v.dataSource && !(v.dataSource in params) && params.push(v.dataSource)
    }
  }
  return params;
}
/*//操作operation数据
 function formatOperation(data) {
 var newData = data;
 if (newData && newData.length > 0) {
 for (var i = 0; i < newData.length; i++) {
 if (newData[i].operationType == 1) {
 newData[i].checked = true;
 } else {
 newData[i].checked = false;
 }
 }
 }
 return newData;
 }*/
//操作layoutInfo数据
function formatLayoutData(data) {
  var groups = data || [];
  for (var key in groups) {
    var v = groups[key];
    var editors = v.editors;
    if (editors) {
      for (var i in editors) {
        var item = editors[i];
        item.readonly = true;
        var extGroups = item.extEditors || item.extGroups || {}
        if (extGroups) {
          for (var j in extGroups) {
            formatLayoutData(extGroups[j])
          }
        }
      }
    } else {
      v.readonly = true
    }
  }
  return groups
}

