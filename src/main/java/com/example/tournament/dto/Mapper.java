package com.example.tournament.dto;
import com.example.tournament.domain.*;
import com.example.tournament.repo.*;
import org.springframework.stereotype.Component;
@Component
public class Mapper {
    CoachRepository coachRepo;
    TeamRepository teamRepo;
    GameRepository gameRepo;
    PlayerRepository playerRepo;
    public Mapper(CoachRepository coachRepo, TeamRepository teamRepo, GameRepository gameRepo, PlayerRepository playerRepo) {
        this.coachRepo = coachRepo;
        this.teamRepo = teamRepo;
        this.gameRepo = gameRepo;
        this.playerRepo = playerRepo;
    }

    //toDto
    public ResponseCoach toDto(Coach coach){
        String firstName = coach.getFirstName();
        String lastName = coach.getLastName();
        return new ResponseCoach(firstName, lastName);
    }
    public ResponseTeam toDto(Team team){
        String teamName = team.getTeamName();
        String city = team.getCity();
        return new ResponseTeam(teamName, city);
    }
    public ResponseGame toDto(Game game){
        String tourNum = game.getTourNum().toString();
        String homeTeamName = game.getHomeTeamId().getTeamName();
        String pointsHomeTeam = game.getPointsH().toString();
        String visitorTeamName = game.getVisitorTeamId().getTeamName();
        String pointsVisitorTeam = game.getPointsV().toString();
        return new ResponseGame(tourNum, homeTeamName,
                pointsHomeTeam, visitorTeamName, pointsVisitorTeam);
    }
    public ResponsePlayer toDto(Player player){
        String firstName = player.getFirstName();
        String lastName = player.getLastname();
        String teamName = player.getTeamId().getTeamName();
        String height = player.getHeight().toString();
        String weight = player.getWeight().toString();
        String positionOnCourt = player.getPositionOnCourt().toString();
        String age = player.getAge().toString();
        return  new ResponsePlayer(firstName, lastName,teamName, height, weight, age, positionOnCourt);
    }
    public ResponseStat toDto(Stat stat){
        String gameId = stat.getGameId().getGameId().toString();
        String playerId = stat.getPlayerId().toString();
        String minutesOnCourt = stat.getMinutesOnCourt().toString();
        String allFreeThrow = stat.getAllFreeThrows().toString();
        String exactFreeThrow = stat.getExactFreeThrows().toString();
        String all2Throw = stat.getAll2Throws().toString();
        String exact2Throw = stat.getExact2Throws().toString();
        String all3Throw = stat.getAll3Throws().toString();
        String exact3Throw = stat.getExact3Throws().toString();
        String assist = stat.getAssists().toString();
        String steal = stat.getSteals().toString();
        String block = stat.getBlocks().toString();
        return new ResponseStat(gameId, playerId, minutesOnCourt, allFreeThrow, exactFreeThrow, all2Throw, exact2Throw, all3Throw, exact3Throw, assist, steal, block);
    }
                //toService
    public Coach toCoach(RequestCoach reqcoach){
        if(reqcoach.getCoachId()==null)
            return new Coach(reqcoach.getFirstName(), reqcoach.getLastName());
        else
            return new Coach(Integer.parseInt(reqcoach.getCoachId()), reqcoach.getFirstName(), reqcoach.getLastName());
    }
    public Team toTeam(RequestTeam reqTeam){
        Coach coach = coachRepo.findById(Integer.parseInt(reqTeam.coachId)).get();
        if(reqTeam.getTeamId()==null)
            return new Team(reqTeam.getTeamName(), reqTeam.getCity(), coach);
        else
            return new Team(Integer.parseInt(reqTeam.getTeamId()), reqTeam.getTeamName(), reqTeam.getCity(), coach);
    }
    public Game toGame(RequestGame reqGame){
        Team homeTeam = teamRepo.findById(Integer.parseInt(reqGame.getHomeTeamId())).get();
        Team visitTeam = teamRepo.findById(Integer.parseInt(reqGame.getVisitTeamId())).get();
        if(reqGame.getGameId()==null)
            return new Game(Integer.parseInt(reqGame.getTourNum()), homeTeam, visitTeam,Integer.parseInt(reqGame.getPointsHomeTeam()),
                    Integer.parseInt(reqGame.getPointsVisitTeam()));
        else
            return new Game(Integer.parseInt(reqGame.getGameId()),Integer.parseInt(reqGame.getTourNum()), homeTeam, visitTeam,
                    Integer.parseInt(reqGame.getPointsHomeTeam()),Integer.parseInt(reqGame.getPointsVisitTeam()));
    }
    public Player toPlayer(RequestPlayer reqPlayer){
        Team team = teamRepo.findById(Integer.parseInt(reqPlayer.getTeamId())).get();
        if(reqPlayer.getPlayerId()==null)
            return new Player(team, reqPlayer.getFirstName(), reqPlayer.getLastName(),
                    Integer.parseInt(reqPlayer.getHeight()),Integer.parseInt(reqPlayer.getWeight()),Integer.parseInt(reqPlayer.getAge()),
                    Integer.parseInt(reqPlayer.getPositionOnCourt()));
        else
            return new Player(Integer.parseInt(reqPlayer.getPlayerId()),team, reqPlayer.getFirstName(), reqPlayer.getLastName(),
                    Integer.parseInt(reqPlayer.getHeight()),Integer.parseInt(reqPlayer.getWeight()),Integer.parseInt(reqPlayer.getAge()),
                    Integer.parseInt(reqPlayer.getPositionOnCourt()));
    }
    public Stat toStat(RequestStat reqStat){
        Game game = gameRepo.findById(Integer.parseInt(reqStat.getGameId())).get();
        Player player = playerRepo.findById(Integer.parseInt(reqStat.getPlayerId())).get();
        if(reqStat.getStatId()==null)
            return new Stat(game, player, Integer.parseInt(reqStat.getMinutesOnCourt()), Integer.parseInt(reqStat.getAllFreeThrows()),
                    Integer.parseInt(reqStat.getExactFreeThrows()),Integer.parseInt(reqStat.getAll2Throws()), Integer.parseInt(reqStat.getExact2Throws()),
                    Integer.parseInt(reqStat.getAll3Throws()), Integer.parseInt(reqStat.getExact3Throws()),Integer.parseInt(reqStat.getAssists()),
                    Integer.parseInt(reqStat.getSteals()), Integer.parseInt(reqStat.getBlocks()) );
        else
            return new Stat(Integer.parseInt(reqStat.getStatId()),player, game, Integer.parseInt(reqStat.getMinutesOnCourt()),
                    Integer.parseInt(reqStat.getAllFreeThrows()), Integer.parseInt(reqStat.getExactFreeThrows()),Integer.parseInt(reqStat.getAll2Throws()),
                    Integer.parseInt(reqStat.getExact2Throws()), Integer.parseInt(reqStat.getAll3Throws()), Integer.parseInt(reqStat.getExact3Throws()),
                    Integer.parseInt(reqStat.getAssists()), Integer.parseInt(reqStat.getSteals()), Integer.parseInt(reqStat.getBlocks()) );
    }
}
