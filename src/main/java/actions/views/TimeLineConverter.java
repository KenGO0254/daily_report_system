package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.TimeLine;

public class TimeLineConverter {
	/**
     * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
     * @param rv ReportViewのインスタンス
     * @return Reportのインスタンス
     */
    public static TimeLine toModel(TimeLineView tlv) {
        return new TimeLine(
                tlv.getId(),
                EmployeeConverter.toModel(tlv.getLoginEmployee()),
                EmployeeConverter.toModel(tlv.getFollowEmployee()),
                tlv.getCreatedAt(),
                tlv.getUpdatedAt());
    }

    /**
     * DTOモデルのインスタンスからViewモデルのインスタンスを作成する
     * @param r Reportのインスタンス
     * @return ReportViewのインスタンス
     */
    public static TimeLineView toView(TimeLine tl) {

        if (tl == null) {
            return null;
        }

        return new TimeLineView(
        		tl.getId(),
        		EmployeeConverter.toView(tl.getLoginEmployee()),
        		EmployeeConverter.toView(tl.getFollowEmployee()),
        		tl.getCreatedAt(),
        		tl.getUpdatedAt());
     }

    /**
     * DTOモデルのリストからViewモデルのリストを作成する
     * @param list DTOモデルのリスト
     * @return Viewモデルのリスト
     */
    public static List<TimeLineView> toViewList(List<TimeLine> list) {
        List<TimeLineView> evs = new ArrayList<>();

        for (TimeLine tl : list) {
            evs.add(toView(tl));
        }

        return evs;
    }

    /**
     * Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
     * @param r DTOモデル(コピー先)
     * @param rv Viewモデル(コピー元)
     */
    public static void copyViewToModel(TimeLine tl, TimeLineView tlv) {
    	tl.setId(tlv.getId());
    	tl.setLoginEmployee(EmployeeConverter.toModel(tlv.getLoginEmployee()));
    	tl.setFollowEmployee(EmployeeConverter.toModel(tlv.getFollowEmployee()));
    	tl.setCreatedAt(tlv.getCreatedAt());
    	tl.setUpdatedAt(tlv.getUpdatedAt());
    }
}
