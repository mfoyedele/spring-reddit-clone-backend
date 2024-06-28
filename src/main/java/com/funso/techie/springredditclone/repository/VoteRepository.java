package com.funso.techie.springredditclone.repository;

import com.funso.techie.springredditclone.model.Post;
import com.funso.techie.springredditclone.model.User;
import com.funso.techie.springredditclone.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}