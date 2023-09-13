package com.spring.member.service.lsy0913;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
// 경로 변경
import com.spring.member.dao.lsy0913.MemberDAO;
import com.spring.member.vo.MemberVO;

/*@Transactional(propagation=Propagation.REQUIRED) */
// 동네 2번-2 , 
public class MemberServiceImpl  implements MemberService{
	// 실제 작업은 외주 , 동네 3번으로 가기위한 인스턴스 작업.
	// DI, 세터 형식으로 초기화 했고, xml 설정파일 정의 된 대로 초기화 합니다. 
	   private MemberDAO memberDAO;
	   public void setMemberDAO(MemberDAO memberDAO){
	      this.memberDAO = memberDAO;
	   }

	   // 기능 
	   @Override
	   public List listMembers() throws DataAccessException {
		   // 임시 데이터를 담기 위한 인스턴스 
	      List membersList = null;
	      // 실제 작업, 외주  동네 3번으로 갑니다. 
	      membersList = memberDAO.selectAllMemberList();
	      // 동네 3번 , 4번, DB 찍고 돌아 옴. 
	      return membersList;
	   }
	   // 한 회원의 정보 가져오기 추가 부분. 
	   @Override
		public MemberVO getOneMember(String id) throws DataAccessException {
		   MemberVO membervo = null;
		   // 실제 작업, 동네 3번, dao 외주 주기. 
		   membervo = memberDAO.selectOneMember(id);
			return membervo;
		}

	   @Override
	   public int addMember(MemberVO memberVO) throws DataAccessException {
	     return memberDAO.insertMember(memberVO);
	   }


	   @Override
	   public int removeMember(String id) throws DataAccessException {
	      return memberDAO.deleteMember(id);
	   }

	
}
