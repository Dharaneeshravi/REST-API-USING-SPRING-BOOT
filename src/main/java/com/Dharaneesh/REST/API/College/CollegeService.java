package com.Dharaneesh.REST.API.College;

import java.util.List;

public interface CollegeService {
    List<College> getCollege();

    void createCollege(College college);

    College getCollegeById(Long id);

    boolean updateCollegeById(Long id,College college);

    boolean deleteCollegeById(Long id);
}
