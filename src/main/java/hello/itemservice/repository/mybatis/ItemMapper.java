package hello.itemservice.repository.mybatis;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {
    //마이바티스 매핑 xml 을 호출해주는 매퍼 인터페이스

    void save(Item item);
    void update (@Param("id") Long id, @Param("updateParam")ItemUpdateDto updateDto); // 파라미터 여러개면 붙여주삼
    List<Item> findAll(ItemSearchCond itemSearch);
    Optional<Item> findById(Long id);
}
