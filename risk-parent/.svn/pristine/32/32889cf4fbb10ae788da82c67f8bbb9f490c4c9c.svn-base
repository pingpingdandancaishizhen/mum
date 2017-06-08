package cn.sunfit.risk.web.controller.order;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.sunfit.risk.buz.api.beans.p2p.P2PProduct;
import cn.sunfit.risk.buz.api.beans.p2p.ProductType;
import cn.sunfit.risk.buz.api.beans.p2p.order.LoanInfoAttachment;
import cn.sunfit.risk.buz.api.constants.order.OrderStatus;
import cn.sunfit.risk.buz.api.service.p2p.order.OrderService;
import cn.sunfit.risk.buz.api.service.p2p.product.P2PProductService;
import cn.sunfit.risk.buz.api.service.p2p.productType.ProductTypeService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.web.controller.BaseController;
import cn.sunfit.risk.web.utils.OSSUtil;
import cn.sunfit.risk.web.utils.UrlUtil;

@Controller
@RequestMapping("/order/attach")
public class AttachController extends BaseController {
    @Autowired
    private OSSUtil ossUtil;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    P2PProductService p2PProductService;

    @ResponseBody
    @RequestMapping(value = "/removeAttach", method = RequestMethod.POST)
    public Resp loadAllLoanByCustomer(@RequestParam(required = true) Long attachId) {
        orderService.removeAttach(attachId, getCurrentUser());
        return new Resp();
    }

    @RequestMapping(value = "/loadLoanAttach", method = RequestMethod.GET)
    public String loadLoanAttach(@RequestParam(required = true) Long attachId, ModelMap map) {
        List<ProductType> ls = productTypeService.findAll();
        List<P2PProduct> lss = p2PProductService.queryAllRiskProduct(getCurrentUser().getDomain());
        map.put("products", lss);
        map.put("producttypes", ls);
        map.put("orderStatus", OrderStatus.values());
        return "/attach/loadLoanAttach";
    }

    @RequestMapping(value = "/uploadLoanAttach", method = RequestMethod.POST)
    @ResponseBody
    public Resp uploadLoanAttach(@RequestParam(required = true) MultipartFile file,
            @RequestParam(required = true) String loanInfoId, @RequestParam(required = true) String attachGroup,
            @RequestParam(required = true) String attachType) {
        Long size = file.getSize();
        if (size > 10 * 1024 * 1024) {
            return Resp.buildErrorResponse("上传文件大超过10M，请重新上传！", "");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String suffix = file.getOriginalFilename().toString()
                .substring(file.getOriginalFilename().toString().lastIndexOf("."));
        String key = UrlUtil.getLOGOUrl("p2puploader", dateFormat.format(new Date()), suffix);
        try {
            ossUtil.uploadFile(key, file.getBytes());
        } catch (IOException e) {
            logger.error("file getBytes exception," + e.getMessage());
            throw new RuntimeException("file getBytes exception," + e.getMessage());
        }
        String coverUrl = ossUtil.buildUrl(key);
        LoanInfoAttachment loanInfoAttachment = new LoanInfoAttachment();
        loanInfoAttachment.setAttachSize(String.valueOf(size));
        loanInfoAttachment.setAttachOldName(file.getOriginalFilename().toString());
        String[] keys = key.split("/");
        loanInfoAttachment.setAttachNewName(keys[keys.length - 1]);
        loanInfoAttachment.setAttachPath(key);
        loanInfoAttachment.setAttachGroup(attachGroup);
        loanInfoAttachment.setAttachType(attachType);
        loanInfoAttachment.setFullPath(coverUrl);
        loanInfoAttachment.setLoanInfoId(loanInfoId);
        orderService.insertLoanInfoAttach(loanInfoAttachment, getCurrentUser());
        return new Resp("upload success!");
    }
}
