'use strict';

// unary
var cnst = function (value) {
    return function (x) {
        return value;
    }
}

var variable = function (name) {
    return function (x) {
        return x;
    }
}


// binary
var binary = function (apply) {
    return function (left, right) {
        return function (x) {
            return apply(left(x), right(x));
        };
    }
};

var add = binary(
    function (left, right) {
        return left + right;
    }
);

var subtract = binary(
    function (left, right) {
        return left - right;
    }
);

var multiply = binary(
    function (left, right) {
        return left * right;
    }
);

var divide = binary(
    function (left, right) {
        return left / right;
    }
);