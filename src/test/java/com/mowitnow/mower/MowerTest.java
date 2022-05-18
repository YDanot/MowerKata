package com.mowitnow.mower;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.mowitnow.mower.Direction.*;
import static com.mowitnow.mower.Instruction.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MowerTest {

    @Test
    void rotate_to_east_when_rotate_right_from_north_initial_position() {
        Position initialPosition = new Position(0, 0, NORTH);
        Instructions instructions = new Instructions();
        instructions.add(RIGHT);

        Mower mower = new Mower(initialPosition, instructions);
        mower.start();

        assertThat(mower.position()).isEqualTo(new Position(0, 0, EAST));
    }

    @Test
    void rotate_to_west_when_rotate_left_from_north_initial_position() {
        Position initialPosition = new Position(0, 0, NORTH);
        Instructions instructions = new Instructions();
        instructions.add(LEFT);

        Mower mower = new Mower(initialPosition, instructions);
        mower.start();

        assertThat(mower.position()).isEqualTo(new Position(0, 0, WEST));
    }

    @Test
    void rotate_to_south_when_rotate_right_from_east_initial_position() {
        Position initialPosition = new Position(0, 0, EAST);
        Instructions instructions = new Instructions();
        instructions.add(RIGHT);

        Mower mower = new Mower(initialPosition, instructions);
        mower.start();

        assertThat(mower.position()).isEqualTo(new Position(0, 0, SOUTH));
    }

    @Test
    void rotate_to_north_when_rotate_left_from_east_initial_position() {
        Position initialPosition = new Position(0, 0, EAST);
        Instructions instructions = new Instructions();
        instructions.add(LEFT);

        Mower mower = new Mower(initialPosition, instructions);
        mower.start();

        assertThat(mower.position()).isEqualTo(new Position(0, 0, NORTH));
    }

    @Test
    void rotate_to_west_when_rotate_right_from_south_initial_position() {
        Position initialPosition = new Position(0, 0, SOUTH);
        Instructions instructions = new Instructions();
        instructions.add(RIGHT);

        Mower mower = new Mower(initialPosition, instructions);
        mower.start();

        assertThat(mower.position()).isEqualTo(new Position(0, 0, WEST));
    }

    @Test
    void rotate_to_east_when_rotate_left_from_south_initial_position() {
        Position initialPosition = new Position(0, 0, SOUTH);
        Instructions instructions = new Instructions();
        instructions.add(LEFT);

        Mower mower = new Mower(initialPosition, instructions);
        mower.start();

        assertThat(mower.position()).isEqualTo(new Position(0, 0, EAST));
    }

    @Test
    void rotate_to_north_when_rotate_right_from_west_initial_position() {
        Position initialPosition = new Position(0, 0, WEST);
        Instructions instructions = new Instructions();
        instructions.add(RIGHT);

        Mower mower = new Mower(initialPosition, instructions);
        mower.start();

        assertThat(mower.position()).isEqualTo(new Position(0, 0, NORTH));
    }

    @Test
    void rotate_to_south_when_rotate_left_from_west_initial_position() {
        Position initialPosition = new Position(0, 0, WEST);
        Instructions instructions = new Instructions();
        instructions.add(LEFT);

        Mower mower = new Mower(initialPosition, instructions);
        mower.start();

        assertThat(mower.position()).isEqualTo(new Position(0, 0, SOUTH));
    }

    @Test
    void move_forward_when_A_command_received() {
        Position initialPosition = new Position(0, 0, NORTH);
        Instructions instructions = new Instructions();
        instructions.add(FORWARD);

        Mower mower = new Mower(initialPosition, instructions);
        mower.start();

        assertThat(mower.position()).isEqualTo(new Position(0, 1, NORTH));
    }

    @Test
    void move_multiple_command() {
        Position initialPosition = new Position(1, 2, NORTH);
        Instructions instructions = new Instructions();
        instructions.addAll(List.of(LEFT, FORWARD, LEFT, FORWARD, LEFT, FORWARD, LEFT, FORWARD, FORWARD));

        Mower mower = new Mower(initialPosition, instructions);
        mower.start();

        assertThat(mower.position()).isEqualTo(new Position(1, 3, NORTH));
    }
}
