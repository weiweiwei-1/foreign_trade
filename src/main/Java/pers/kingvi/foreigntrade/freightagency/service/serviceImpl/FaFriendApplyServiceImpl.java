package pers.kingvi.foreigntrade.freightagency.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.kingvi.foreigntrade.admin.dao.FriendApplyMapper;
import pers.kingvi.foreigntrade.foreigntradesaleman.dao.ForeignTradeSalemanMapper;
import pers.kingvi.foreigntrade.freightagency.service.FaFriendApplyService;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.FriendApply;
import pers.kingvi.foreigntrade.vo.FriendApplyVo;

import java.util.ArrayList;
import java.util.List;

@Service
public class FaFriendApplyServiceImpl implements FaFriendApplyService {

    @Autowired
    private FriendApplyMapper friendApplyMapper;

    @Autowired
    private ForeignTradeSalemanMapper foreignTradeSalemanMapper;

    @Override
    public List<FriendApplyVo> selectByFaId(Long receiverId) {
        List<FriendApply> friendApplyList = friendApplyMapper.selectByReceiverId(receiverId);
        List<FriendApplyVo> friendApplyVoList = new ArrayList<>();
        List<Long> ftsIdList = new ArrayList<>();
        FriendApplyVo friendApplyVo = new FriendApplyVo();
        if (friendApplyList.size() > 0) {
            for (FriendApply friendApply : friendApplyList) {
                friendApplyVo.setSendTime(friendApply.getSendTime());
                friendApplyVo.setSenderId(friendApply.getSenderId());
                friendApplyVo.setSenderName(friendApplyVo.getSenderName());
                ftsIdList.add(friendApply.getSenderId());
                friendApplyVoList.add(friendApplyVo);
            }
            List<ForeignTradeSaleman> foreignTradeSalemanList = foreignTradeSalemanMapper.selectByFtsIdList(ftsIdList);
            for (int i = 0; i < friendApplyList.size(); i++) {
                friendApplyVoList.get(i).setPhoto(foreignTradeSalemanList.get(i).getPhoto());
            }
            return  friendApplyVoList;
        }
        return null;
    }
}
