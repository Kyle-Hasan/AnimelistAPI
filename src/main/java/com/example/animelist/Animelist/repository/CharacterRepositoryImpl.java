package com.example.animelist.Animelist.repository;

import com.example.animelist.Animelist.dto.CharacterRoleDTO;
import com.example.animelist.Animelist.entity.Character;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


@Repository
public class CharacterRepositoryImpl extends BaseRepositoryImpl<Character> implements CharacterRepository {

    @Autowired
    public CharacterRepositoryImpl(MongoTemplate mongoTemplate) {

        super(mongoTemplate,Character.class);





    }




    @Override
    public List<CharacterRoleDTO> getCharacterRoles(List<String> characterIds) {
        MatchOperation matchOperation = Aggregation.match(Criteria.where("_id").in(characterIds));
        LookupOperation lookupVoiceActors = Aggregation.lookup("people","voiceActorRoleList.voiceActorId","_id","voiceActorDetails");
        LookupOperation lookupAnime = Aggregation.lookup("anime","voiceActorRoleList.animeId","_id","anime");
        ProjectionOperation projectionOperation = Aggregation.project()
                .and("_id").as("characterId")
                .and("name").as("characterName")
                .and("pictureURL").as("characterPictureURL")
                .and("voiceActorDetails._id").as("voiceActorId")
                .and("voiceActorDetails.familyName").as("voiceActorFamilyName")
                .and("voiceActorDetails.givenName").as("voiceActorGivenName")
                .and("voiceActorDetails.language").as("language")
                .and("anime.name").as("animeName")
                .and("anime._id").as("animeId")
                .and("voiceActorDetails.pictureURL").as("voiceActorPictureURL")
                .and("anime.pictureURL").as("animePictureURL");
        UnwindOperation unwindVoiceActorRoles = Aggregation.unwind("voiceActorRoleList");
        UnwindOperation unwindVoiceActorDetails = Aggregation.unwind("voiceActorDetails");
        UnwindOperation unwindAnime = Aggregation.unwind("anime");

        Aggregation aggreation = Aggregation.newAggregation(
                matchOperation,
                unwindVoiceActorRoles,
                lookupVoiceActors,
                lookupAnime,
                unwindAnime,
                unwindVoiceActorDetails,
                projectionOperation
        );
        System.out.println("Aggregation Pipeline: " + aggreation.toString());
        AggregationResults<CharacterRoleDTO> results = mongoTemplate.aggregate(aggreation,"character",CharacterRoleDTO.class);
        List<CharacterRoleDTO> resultsMapped = results.getMappedResults();


        return resultsMapped;

    }

    @Override
    public List<CharacterRoleDTO> getCharacterRolesAnime(List<String> animeIds) {
        List<ObjectId> objectIds = animeIds.stream()
                .map(ObjectId::new) // Convert String to ObjectId
                .toList();
        MatchOperation matchOperation = Aggregation.match(Criteria.where("voiceActorRoleList.animeId").in(objectIds));
        LookupOperation lookupVoiceActors = Aggregation.lookup("people","voiceActorRoleList.voiceActorId","_id","voiceActorDetails");
        ProjectionOperation projectionOperation = Aggregation.project()
                .and("_id").as("characterId")
                .and("name").as("characterName")
                .and("pictureURL").as("characterPictureURL")
                .and("voiceActorDetails._id").as("voiceActorId")
                .and("voiceActorDetails.familyName").as("voiceActorFamilyName")
                .and("voiceActorDetails.givenName").as("voiceActorGivenName")
                .and("voiceActorDetails.language").as("language")
                .and("anime.name").as("animeName")
                .and("anime._id").as("animeId")
                .and("voiceActorDetails.pictureURL").as("voiceActorPictureURL")
                .and("anime.pictureURL").as("animePictureURL");
        UnwindOperation unwindVoiceActorRoles = Aggregation.unwind("voiceActorRoleList");
        UnwindOperation unwindVoiceActorDetails = Aggregation.unwind("voiceActorDetails");

        Aggregation aggreation = Aggregation.newAggregation(
                matchOperation,
                unwindVoiceActorRoles,
                lookupVoiceActors,
                unwindVoiceActorDetails,
                projectionOperation
        );
        System.out.println("Aggregation Pipeline: " + aggreation.toString());
        AggregationResults<CharacterRoleDTO> results = mongoTemplate.aggregate(aggreation,"character",CharacterRoleDTO.class);
        List<CharacterRoleDTO> resultsMapped = results.getMappedResults();
        return resultsMapped;

    }

    @Override
    public List<CharacterRoleDTO> getCharacterRolesVoiceActor(List<String> voiceActorIds) {
        List<ObjectId> objectIds = voiceActorIds.stream()
                .map(ObjectId::new) // Convert String to ObjectId
                .toList();
        MatchOperation matchOperation = Aggregation.match(Criteria.where("voiceActorRoleList.voiceActorId").in(objectIds));
        ProjectionOperation projectionOperation = Aggregation.project()
                .and("_id").as("characterId")
                .and("name").as("characterName")
                .and("pictureURL").as("characterPictureURL")
                .and("voiceActorDetails._id").as("voiceActorId")
                .and("voiceActorDetails.familyName").as("voiceActorFamilyName")
                .and("voiceActorDetails.givenName").as("voiceActorGivenName")
                .and("voiceActorDetails.language").as("language")
                .and("anime.name").as("animeName")
                .and("anime._id").as("animeId")
                .and("voiceActorDetails.pictureURL").as("voiceActorPictureURL")
                .and("anime.pictureURL").as("animePictureURL");
        UnwindOperation unwindVoiceActorRoles = Aggregation.unwind("voiceActorRoleList");
        LookupOperation lookupAnime = Aggregation.lookup("anime","voiceActorRoleList.animeId","_id","anime");
        UnwindOperation unwindAnime = Aggregation.unwind("anime");
        Aggregation aggreation = Aggregation.newAggregation(
                matchOperation,
                unwindVoiceActorRoles,
                lookupAnime,
                unwindAnime,

                projectionOperation
        );
        System.out.println("Aggregation Pipeline: " + aggreation.toString());
        AggregationResults<CharacterRoleDTO> results = mongoTemplate.aggregate(aggreation,"character",CharacterRoleDTO.class);
        List<CharacterRoleDTO> resultsMapped = results.getMappedResults();
        return resultsMapped;

    }
}
