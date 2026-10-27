# PRINCE GODFREY S. PEPITO              BSCS 2-Y1-1
# ACTIVITY 5: MIDTERM LAB ACTIVITY - 5
# PART B: DOUBLY LINKED LIST

class SongNode:
    def __init__(self, title):
        self.title = title
        self.prev = None
        self.next = None


class Playlist:
    def __init__(self):
        self.head = None
        self.tail = None
        self.current = None

    # Add a song at the end
    def add_song(self, title):
        new_song = SongNode(title)

        if self.head is None:
            self.head = new_song
            self.tail = new_song
            self.current = new_song

        else:
            new_song.prev = self.tail
            self.tail.next = new_song
            self.tail = new_song

        print("Song added:", title)

    # Move to the next song
    def next_song(self):
        if self.current is None:
            print("The playlist is empty.")

        elif self.current.next is None:
            print("You are already at the last song.")

        else:
            self.current = self.current.next
            print("Current:", self.current.title)

    # Move to the previous song
    def previous_song(self):
        if self.current is None:
            print("The playlist is empty.")

        elif self.current.prev is None:
            print("You are already at the first song.")

        else:
            self.current = self.current.prev
            print("Current:", self.current.title)

    # Display the current song
    def show_current(self):
        if self.current is None:
            print("The playlist is empty.")
        else:
            print("Current:", self.current.title)

    # Display songs from head to tail
    def display_forward(self):
        if self.head is None:
            print("The playlist is empty.")
            return

        song = self.head
        print("Forward:", end=" ")

        while song is not None:
            print(song.title, end="")

            if song.next is not None:
                print(" <-> ", end="")

            song = song.next

        print()

    # Display songs from tail to head
    def display_backward(self):
        if self.tail is None:
            print("The playlist is empty.")
            return

        song = self.tail
        print("Backward:", end=" ")

        while song is not None:
            print(song.title, end="")

            if song.prev is not None:
                print(" <-> ", end="")

            song = song.prev

        print()

    # Remove the first matching song
    def remove_song(self, title):
        song = self.head

        while song is not None and song.title != title:
            song = song.next

        if song is None:
            print("Song not found:", title)
            return False

        previous = song.prev
        following = song.next

        # Update the previous node or the head
        if previous is None:
            self.head = following
        else:
            previous.next = following

        # Update the next node or the tail
        if following is None:
            self.tail = previous
        else:
            following.prev = previous

        # Update current if the removed song was selected
        if self.current == song:
            if following is not None:
                self.current = following
            else:
                self.current = previous

        # Disconnect the removed node
        song.prev = None
        song.next = None

        print("Removed:", title)
        return True


def main():
    playlist = Playlist()

    while True:
        print("\n======= CAMPUS MUSIC PLAYLIST =======")
        print("1. Add song")
        print("2. Next song")
        print("3. Previous song")
        print("4. Show current song")
        print("5. Display playlist forward")
        print("6. Display playlist backward")
        print("7. Remove song")
        print("0. Exit")

        choice = input("Enter your choice: ").strip()

        match choice:
            case "1":
                title = input("Enter song title: ").strip()

                if title:
                    playlist.add_song(title)
                else:
                    print("Song title cannot be empty.")

            case "2":
                playlist.next_song()

            case "3":
                playlist.previous_song()

            case "4":
                playlist.show_current()

            case "5":
                playlist.display_forward()

            case "6":
                playlist.display_backward()

            case "7":
                title = input("Enter song title to remove: ").strip()

                if title:
                    playlist.remove_song(title)
                else:
                    print("Song title cannot be empty.")

            case "0":
                print("Exiting playlist program. Goodbye!")
                break

            case _:
                print("Invalid option. Please try again.")


if __name__ == "__main__":
    main()
