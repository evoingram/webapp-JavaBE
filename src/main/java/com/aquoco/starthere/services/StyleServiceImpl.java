package com.aquoco.starthere.services;

import com.aquoco.starthere.exceptions.ResourceFoundException;
import com.aquoco.starthere.exceptions.ResourceNotFoundException;
import com.aquoco.starthere.logging.Loggable;
import com.aquoco.starthere.models.Style;
import com.aquoco.starthere.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
 * style table fields: sid, stylename
 */
@Loggable
@Service(value = "styleService")
public class StyleServiceImpl implements StyleService {

    @Autowired
    private StyleRepository stylerepo;


    public Style findStyleById(long id) throws
            ResourceNotFoundException {
        return stylerepo.findById(id)
                     .orElseThrow(() -> new ResourceNotFoundException("Style ID " + id + " not found!"));
    }

    @Override
    public Style findByStylename(String stylename) {

        if (stylerepo.findByStylename(stylename.toLowerCase()) == null) {
            throw new ResourceNotFoundException("Stylename " + stylename + " not found!");
        }
        return stylerepo.findByStylename(stylename.toLowerCase());

    }

    @Override
    public List<Style> findByStylenameContainingIgnoreCase(String stylename,
                                                             Pageable pageable) {
        return stylerepo.findByStylenameContainingIgnoreCase(stylename,
                                                              pageable);
    }

    @Override
    public List<Style> findAll(Pageable pageable) {
        List<Style> list = new ArrayList<>();
        stylerepo.findAll(pageable)
              .iterator()
              .forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public void delete(long id, boolean isAdmin) {

        if (isAdmin) {
            stylerepo.findById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("sid " + id + " not found!"));
            stylerepo.deleteById(id);
        }
    }

    @Transactional
    @Override
    public Style save(Style stylename, boolean isAdmin) {

        if (isAdmin) {

            if (stylerepo.findByStylename(stylename.getStylename()) != null) {
                throw new ResourceFoundException(stylename.getStylename() + " is already taken!");
            }

            Style newStyle = new Style();
            newStyle.setStylename(stylename.getStylename());

            if (newStyle.getStylename() != null) {
                newStyle.setStylename(stylename.getStylename());
            }

            return stylerepo.save(newStyle);
        }

        return null;
    }

    @Transactional
    @Override
    public Style update(Style styleName,
                                long id,
                                boolean isAdmin) {

        if (isAdmin) {

            Style currentStyle = findStyleById(id);


            if(styleName.getStylename() != null) {
                currentStyle.setStylename(styleName.getStylename());
            }


            return stylerepo.save(currentStyle);

        } else {
            throw new ResourceNotFoundException(id + " not current style");
        }


    }

}
