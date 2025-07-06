// problem link: https://leetcode.com/problems/evaluate-reverse-polish-notation

// notes: try catch block should not be used for control flow, only exceptional
// circumstances. It both goes against what try/catch is for, and is a very
// expensive process that increased runtime greatly.

#include <stack>

class Solution {  // 0ms beats 100%
 public:
  int evalRPN(std::vector<std::string>& tokens) {
    std::stack<int> stack;

    for (const auto& token : tokens) {
      if (token == "+" || token == "-" || token == "*" || token == "/") {
        int second_operand = stack.top();
        stack.pop();
        int first_operand = stack.top();
        stack.pop();

        if (token == "+")
          stack.push(first_operand + second_operand);
        else if (token == "-")
          stack.push(first_operand - second_operand);
        else if (token == "/")
          stack.push(first_operand / second_operand);
        else if (token == "*")
          stack.push(first_operand * second_operand);
      } else {
        stack.push(std::stoi(token));
      }
    }
    return stack.top();
  }
};

class Solution {  // 301ms beats 5%
 public:
  int evalRPN(std::vector<std::string>& tokens) {
    std::stack<int> stack;

    for (const auto& token : tokens) {
      try {
        stack.push(std::stoi(token));
      } catch (std::invalid_argument) {
        int second_operand = stack.top();
        stack.pop();
        int first_operand = stack.top();
        stack.pop();

        char operation = token[0];

        if (operation == '+') stack.push(first_operand + second_operand);
        if (operation == '-') stack.push(first_operand - second_operand);
        if (operation == '/') stack.push(first_operand / second_operand);
        if (operation == '*') stack.push(first_operand * second_operand);
      }
    }
    return stack.top();
  }
};