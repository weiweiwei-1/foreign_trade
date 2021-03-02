package pers.kingvi.foreigntrade.foreigntradesaleman.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.FriendApplyMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.FtsFriendApplyService;
import pers.kingvi.foreigntrade.freightagency.dao.FreightAgencyMapper;
import pers.kingvi.foreigntrade.po.*;
import pers.kingvi.foreigntrade.vo.FriendApplyVo;

import java.util.ArrayList;
import java.util.List;

@Service
public class FtsFriendApplyServiceImpl implements FtsFriendApplyService {

    @Autowired
    private FriendApplyMapper friendApplyMapper;

    @Autowired
    private FreightAgencyMapper freightAgencyMapper;

    @Override
    public List<FriendApplyVo> selectByFtsId(Long receiverId) {
        List<FriendApply> friendApplyList = friendApplyMapper.selectByReceiverId(receiverId);
        List<FriendApplyVo> friendApplyVoList = new ArrayList<>();
        List<Long> faIdList = new ArrayList<>();
        FriendApplyVo friendApplyVo = new FriendApplyVo();
        if (friendApplyList.size() > 0) {
            for (FriendApply friendApply : friendApplyList) {
                friendApplyVo.setSendTime(friendApply.getSendTime());
                friendApplyVo.setSenderId(friendApply.getSenderId());
                friendApplyVo.setSenderName(friendApplyVo.getSenderName());
                faIdList.add(friendApply.getSenderId());
                friendApplyVoList.add(friendApplyVo);
            }
            List<FreightAgency> freightAgencyList = freightAgencyMapper.selectByFaIdList(faIdList);
            for (int i = 0; i < friendApplyList.size(); i++) {
                friendApplyVoList.get(i).setPhoto(freightAgencyList.get(i).getPhoto());
            }
            return  friendApplyVoList;
        }
        return null;
    }

}
