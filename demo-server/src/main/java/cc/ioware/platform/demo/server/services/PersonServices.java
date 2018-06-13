package cc.ioware.platform.demo.server.services;

import cc.ioware.platform.demo.server.repo.entity.PersonEntity;
import cc.ioware.platform.demo.server.repo.r.PersonRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PersonServices {

    private PersonRepo personRepo;

    @Autowired
    PersonServices(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public List<PersonEntity> getPersons() {
        List<PersonEntity> persons = personRepo.findAll();
        return persons;
    }


    /**
     * 默认从缓存中获取，缓存中如果没有，则从数据库中获取，并且结果不为null，则将结果放入到缓存中
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "person:hello", key = "#aid", unless = "#result == null")
    public PersonEntity getPerson(Long aid) {
        log.info("return from mysql");
        Optional<PersonEntity> p = personRepo.findById(aid);
        return p.orElse(null);
    }

    /**
     * 更新缓存，这个一定会更新数据库
     * @param p
     * @return
     */
    @CachePut(cacheNames = "person:hello", key = "#result.id", unless = "#result == null")
    public PersonEntity savePerson(PersonEntity p) {
        PersonEntity np = personRepo.save(p);
        log.info("存储到缓存中，每次都会调用");
        return np;
    }
}
