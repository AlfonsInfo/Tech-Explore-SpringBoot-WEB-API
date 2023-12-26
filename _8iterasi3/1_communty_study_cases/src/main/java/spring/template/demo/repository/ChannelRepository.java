package spring.template.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.template.demo.channel.Channel;

public interface ChannelRepository extends JpaRepository<Channel, String> {
    public boolean existsByPathAndRequestMethod(String path, String requestMethod);
}
