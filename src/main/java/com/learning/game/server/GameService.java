package com.learning.game.server;

import com.learning.models.Die;
import com.learning.models.GameServiceGrpc;
import com.learning.models.GameState;
import com.learning.models.Player;
import io.grpc.stub.StreamObserver;

public class GameService extends GameServiceGrpc.GameServiceImplBase {
    @Override
    public StreamObserver<Die> roll(StreamObserver<GameState> responseObserver) {
        Player client = Player.newBuilder().setName("client").setPosition(0).build();
        Player server = Player.newBuilder().setName("server").setPosition(0).build();
        return new DieStreamingRequest(client, server, responseObserver);
    }
}
