package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.MemberDTO;

public class MemberDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	// MemberDAO 싱글톤
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
	// close
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (con != null) { con.close(); }
			if (ps != null) { ps.close(); }
			if (rs != null) { rs.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 전체 회원목록 조회
	public List<MemberDTO> selectMemberList() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			sql = "SELECT NO, ID, NAME, GRADE, POINT\r\n" + 
				    "FROM MEMBER_TABLE";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();		
				dto.setNo(rs.getLong(1));
				dto.setId(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setGrade(rs.getString(4));
				dto.setPoint(rs.getInt(5));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return list;
	}
	
	// 로그인
	public MemberDTO login(MemberDTO dto) {
		MemberDTO loginDTO = null;
		try {
			sql = "SELECT NO, ID, NAME, GRADE, POINT FROM MEMBER_TABLE WHERE ID = ? AND NAME = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			rs = ps.executeQuery();
			if (rs.next()) {
				loginDTO = new MemberDTO();
				loginDTO.setNo(rs.getLong(1));
				loginDTO.setId(rs.getString(2));
				loginDTO.setName(rs.getString(3));
				loginDTO.setGrade(rs.getString(4));
				loginDTO.setPoint(rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return loginDTO;
	}
	
	// 회원가입
	public int joinMember(MemberDTO dto) {
		int result = 0;
		try {
			sql = "INSERT INTO MEMBER_TABLE VALUES (MEMBER_SEQ.NEXTVAL, ?, ?, bronze, 1000)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return result;
	}
	
	// 회원 탈퇴
	public int deleteMember(long no) {
		int result = 0;
		try {
			sql = "DELETE FROM MEMBER_TABLE WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, no);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	
	// plusPointTen
	public void plusPointTen() {
		try {
			sql = "UPDATE MEMBER_TABLE SET POINT = POINT + 10";
			ps = con.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
	}
	
}