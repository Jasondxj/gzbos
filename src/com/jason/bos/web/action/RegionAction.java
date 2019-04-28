package com.jason.bos.web.action;


import com.jason.bos.model.PageBean;
import com.jason.bos.model.Region;
import com.jason.bos.model.Staff;
import com.jason.bos.service.IRegionService;
import com.jason.bos.utils.PinYin4jUtils;
import com.jason.bos.web.action.base.BaseAction;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegionAction extends BaseAction<Region> {
    @Autowired
    private IRegionService regionService;

    private File excelFile;

    public void setExcelFile(File excelFile) {
        this.excelFile = excelFile;
    }

    public String importExcel() throws Exception {
        System.out.println(excelFile.getAbsolutePath());
        //1.解析excel文件中数据
        //1.1创建Workbook
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(excelFile));

        //1.2 获取sheet
        Sheet sheet = workbook.getSheetAt(0);

        //1.3遍历里面数据
        List<Region> list = new ArrayList<Region>();
        for (Row row : sheet) {
            String id = row.getCell(0).getStringCellValue();
            String province = row.getCell(1).getStringCellValue();
            String city = row.getCell(2).getStringCellValue();
            String district = row.getCell(3).getStringCellValue();
            String postcode = row.getCell(4).getStringCellValue();

            //根据中文生成城市编码
            String citycode= StringUtils.join(PinYin4jUtils.stringToPinyin(city));
            //根据中文生成简码
            String cityTmp = city.substring(0,city.length() - 1);
            String districtTmp = district.substring(0,district.length() - 1);
            String[] cityStrs =  PinYin4jUtils.getHeadByString(cityTmp);
            String[] districtStrs = PinYin4jUtils.getHeadByString(districtTmp);
            String shortcode = StringUtils.join(cityStrs,"") + StringUtils.join(districtStrs,"");
            //封装成Region模型
            Region region = new Region(id, province, city, district, postcode);
            region.setCitycode(citycode);
            region.setShortcode(shortcode);
            list.add(region);
        }
        list.remove(0);//表头不存入数据库
        //调用servic
        regionService.saveAll(list);
        responseStr("success");
        return NONE;
    }

    @Override
    public String save() {
        return null;
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public String delete() throws IOException {
        return null;
    }

    @Override
    public String list() {
        return null;
    }

    public void pageQuery() throws IOException {
        //1.接收参数 page[当前页] rows[每页显示多少条]
        //2.调用service,参数里传一个PageBean
        //封装条件
        pb.setCurrentPage(page);
        pb.setPageSize(rows);
        regionService.pageQuery(pb);
        //3.返回json数据
        responseJson(pb, new String[]{"currentPage", "pageSize", "detachedCriteria","subareas"});
    }
    public String listJson() throws IOException {
        List<Region> regions = regionService.findAll();
        /**
         * 转json时，不要转subareas，否则会出现死循环
         */
        responseJson(regions,new String[]{"subareas"});
        return NONE;
    }
}
