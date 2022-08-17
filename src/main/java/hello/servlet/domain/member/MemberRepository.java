package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 동시성 문제가 고려되어 있지 않아서, 실무에서는 ConcurrentHashMap, AtomicLong을 사용하는 것이 좋다.
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {}

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public static List<Member> findAll() {
        return new ArrayList<>(store.values()); // store에 있는 모든 값들을 다 꺼내서 arraylist에 새롭게 만든다. store자체를 보호하기 위해서!
    }

    public void clearStore() {
        store.clear(); // map에있는 메서드 말 그대로 클리닝
    }

}
