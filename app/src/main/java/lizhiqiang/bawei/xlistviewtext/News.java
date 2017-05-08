package lizhiqiang.bawei.xlistviewtext;

import java.util.List;

/**
 * date: 2017/4/29
 * author: 李志强
 * function:
 */

public class News {
    /**
     * ret_code : 200
     * ret_msg : ok
     * list : [{"date":"2小时前","id":2,"pic":"http://img2.imgtn.bdimg.com/it/u=819201812,3553302270&fm=214&gp=0.jpg","title":"明星和岳父的合影曝光：吴奇隆刘强东真尴尬，王祖蓝真心不容易~","type":1},{"date":"1小时前","id":3,"pic":"http://img02.tooopen.com/images/20140504/sy_60294738471.jpg","title":"《人民的名义》观后感：郑胜利居心不良，高育良地下情曝光","type":1},{"date":"4小时前","id":6,"pic":"http://pic7.nipic.com/20100517/3409334_180613088650_2.jpg|http://pic9.nipic.com/20100820/2531170_182750402288_2.jpg|http://pic1a.nipic.com/2008-10-07/20081079019381_2.jpg","title":" \n北京的你再忙也要加一下这个投资微信！不然后悔！","type":2},{"date":"6小时前","id":7,"pic":"http://img0.imgtn.bdimg.com/it/u=574856470,1246558112&fm=23&gp=0.jpg|http://img3.imgtn.bdimg.com/it/u=513882953,1408003522&fm=23&gp=0.jpg|http://img5.imgtn.bdimg.com/it/u=1606735385,4128671428&fm=23&gp=0.jpg","title":" \n盘点2016年互联网上的六大老爸，第五个真的戳中泪点","type":2},{"date":"7小时前","id":8,"pic":"http://pic7.nipic.com/20100517/3409334_180613088650_2.jpg|http://pic9.nipic.com/20100820/2531170_182750402288_2.jpg|http://pic1a.nipic.com/2008-10-07/20081079019381_2.jpg","title":"镜头中的中朝边境，两人背对背却在不同的国家","type":2},{"date":"1分钟前","id":18,"pic":"http://p3.pstatp.com/list/190x124/e5900054f8a11fc5960","title":"深圳男子被吃脑虫入侵去世，哪些食物最危险含寄生虫?","type":1},{"date":"2小时前","id":19,"pic":"http://p9.pstatp.com/list/190x124/ef7000c2947b313fe05","title":" \n为什么越来越多的人会选择关闭朋友圈？","type":1},{"date":"9小时前","id":20,"pic":"http://p1.pstatp.com/list/190x124/18a10004f6a0fb66f371","title":" \n100万元人民币的现金到底有多重？","type":1}]
     */

    private int ret_code;
    private String ret_msg;
    private List<ListBean> list;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * date : 2小时前
         * id : 2
         * pic : http://img2.imgtn.bdimg.com/it/u=819201812,3553302270&fm=214&gp=0.jpg
         * title : 明星和岳父的合影曝光：吴奇隆刘强东真尴尬，王祖蓝真心不容易~
         * type : 1
         */

        private String date;
        private int id;
        private String pic;
        private String title;
        private int type;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
