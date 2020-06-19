package com.harrison.cursoSpringMvc.model.repository;

import com.harrison.cursoSpringMvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {

    private List<Jedi> jediList;

    public JediRepository() {
        this.jediList = new ArrayList<>();
        jediList.add(new Jedi("Luke","Skywalker"));
    }

    public List<Jedi> getAllJedi(){
        return this.jediList;
    }

    public void add(Jedi jedi) {
        this.jediList.add(jedi);
    }
}
