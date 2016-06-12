package be.italent.service;

import be.italent.model.Like;
import be.italent.model.Project;
import be.italent.model.User;
import be.italent.repository.LikeRepo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {
    private static final Logger logger = LogManager.getLogger(LikeServiceImpl.class.getName());

    @Autowired
    private LikeRepo likeRepo;

    /**
     * Toggles the likes status of a {@link be.italent.model.Project} for an authenticated user
     *
     * @param projectId {@link int} The id of the {@link be.italent.model.Project} to be (un)liked
     * @param user      the {@link User} that toggles the like
     * @return a {@link boolean} with the new liked value
     */
    @Override
    public boolean toggleLike(int projectId, User user) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        Like l = new Like();
        l.setUser(user);

        Project p = new Project();
        p.setProjectId(projectId);

        l.setProject(p);

        /**
         * Test if object exists (if not: create new like)
         */
        Like existingLike = likeRepo.getLikeByProject(l.getProject(), l.getUser());

        if (existingLike == null) {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- Like " + projectId);

            // Not likes yet: like
            likeRepo.save(l);
            return true;
        } else {
            logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " --- Like " + projectId);

            // Already likes: unlike
            likeRepo.delete(existingLike);
            return false;
        }

    }
}
