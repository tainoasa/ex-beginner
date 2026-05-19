package com.example.ex_beginner.repository;

import com.example.ex_beginner.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, i) -> {
        Member member = new Member();
        member.setName(rs.getString("name"));
        member.setAge(rs.getInt("age"));
        member.setDepId(rs.getInt("dep_id"));
        return member;
    };

    public List<Member> getName(String keyWord) {
        String sql = "SELECT id, name, age, dep_id FROM members WHERE name LIKE :likeName";

        String likeName = "%" + keyWord + "%";
        SqlParameterSource param = new MapSqlParameterSource().addValue("likeName", likeName);
        List<Member> memberList = template.query(sql, param, MEMBER_ROW_MAPPER); // ←ここに実行の処理を書く

        return memberList;
    }
}
