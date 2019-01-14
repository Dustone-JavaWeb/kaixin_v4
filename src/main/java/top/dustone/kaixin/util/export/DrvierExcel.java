package top.dustone.kaixin.util.export;

import com.xuxueli.poi.excel.annotation.ExcelField;
import com.xuxueli.poi.excel.annotation.ExcelSheet;
import top.dustone.kaixin.entity.Driver;

@ExcelSheet(name="机手列表")
public class DrvierExcel {
    @ExcelField(name = "ID")
    private Integer id;
    @ExcelField(name = "姓名")
    private String name;
    @ExcelField(name = "电话")
    private String tel;
    @ExcelField(name = "身份证号码")
    private String personId;
    @ExcelField(name = "驾驶证号码")
    private String paperId;

    public DrvierExcel(Driver driver){
        this.id=driver.getId();
        this.name=driver.getName();
        this.tel=driver.getTel();
        this.personId=driver.getPersonId();
        this.paperId=driver.getPaperId();
    }
    public DrvierExcel(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }
}
