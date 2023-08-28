package restfulAPI.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import restfulAPI.restful.entity.ErrorDictionary;

public interface ErrorMessageRepository extends PagingAndSortingRepository<ErrorDictionary,String> {
}
