package spring.template.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.template.demo.nonmasterdata.channel.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, String> {
    public boolean existsByPathAndRequestMethod(String path, String requestMethod);
}
