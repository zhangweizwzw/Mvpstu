package wholesale.lizi.com.mvpstu.bean;

/**
 * Created by admin on 2017/1/6.
 */


public class CoinBean {
    /**
     * drivecoinnum : 5
     * operationdate : 2017-2-4 17:03:40
     * remark : 每天首次发表话题赠送5驾币
     */

    private String drivecoinnum;
    private String operationdate;
    private String remark;

    public String getDrivecoinnum() {
        return drivecoinnum;
    }

    public void setDrivecoinnum(String drivecoinnum) {
        this.drivecoinnum = drivecoinnum;
    }

    public String getOperationdate() {
        return operationdate;
    }

    public void setOperationdate(String operationdate) {
        this.operationdate = operationdate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
