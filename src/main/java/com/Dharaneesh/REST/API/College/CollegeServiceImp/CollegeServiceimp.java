package com.Dharaneesh.REST.API.College.CollegeServiceImp;

import com.Dharaneesh.REST.API.College.College;
import com.Dharaneesh.REST.API.College.CollegeRepository;
import com.Dharaneesh.REST.API.College.CollegeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CollegeServiceimp implements CollegeService {

    private CollegeRepository collegeRepository;

    public CollegeServiceimp(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    @Override
    public List<College> getCollege() {
        return collegeRepository.findAll();
    }

    @Override
    public void createCollege(College college) {
        collegeRepository.save(college);
    }

    @Override
    public College getCollegeById(Long id) {
        return collegeRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateCollegeById(Long id,College college) {
        Optional<College> college1=collegeRepository.findById(id);
        if(college1.isPresent())
        {
            College college2=college1.get();
            college2.setName(college.getName());
            college2.setCode(college.getCode());
            college2.setLocation(college.getLocation());
            collegeRepository.save(college2);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean deleteCollegeById(Long id) {
        if(collegeRepository.existsById(id))
        {
            collegeRepository.deleteById(id);
            return true;
        }
        else
        {
            return false;
        }
    }
}
