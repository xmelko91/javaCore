package travel.user.repo;

import travel.common.solutions.repo.BaseRepo;
import travel.user.domain.User;
import travel.user.search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo<User, Long> {

    List<User> search(UserSearchCondition searchCondition);
}
