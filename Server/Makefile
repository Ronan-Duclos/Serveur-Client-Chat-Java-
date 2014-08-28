#******************************************************************************#
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: rduclos <rduclos@student.42.fr>            +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2013/11/20 11:38:09 by rduclos           #+#    #+#              #
#    Updated: 2014/03/25 17:01:09 by rduclos          ###   ########.fr        #
#                                                                              #
#******************************************************************************#

NAME =		bin/*.class

SRC =		src/*.java

all: $(NAME)

$(NAME):
	javac -d ./bin $(SRC)

clean:
	clear

fclean: clean
	rm -f $(NAME)

re: fclean all
	
