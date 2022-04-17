package tw.edu.ntub.imd.birc.firstmvc.databaseconfig.dao;

import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.birc.firstmvc.databaseconfig.entity.Member;

import java.util.List;

/*
介面是供使用者(service)呼叫的地方，一個介面不一定只能配一個實作
使用者不需要知道是怎麼完成，只需要讓他呼叫
ex: 販賣機

繼承，可以從父類哪裡取得一些可以使用的方法、變數

使用spring data jpa
 */

// 告訴spring這是一個Repository(DAO)
@Repository
//DAO的介面，要繼承BaseDAO<entity, pk型態>
public interface MemberDAO extends BaseDAO<Member, String> {
    List<Member> findAllByAvailableIsTrue();
}
