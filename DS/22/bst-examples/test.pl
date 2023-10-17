#!/usr/bin/perl
use 5.26.0;
use warnings FATAL => 'all';
use feature qw(signatures);
no warnings "experimental::signatures";
use lib './.lib';

use Test::Simple tests => 23;
use Data::Dumper;

our %EXPECT_TESTS = (
    BinTreeShould => 1,
    TreeSetShould => 7,
    ConsSetShould => 8,
);
our $PKG = "lab08";

use JUnit;

my @reports = JUnit::list_reports();

my %seen = map { $_ => 1 } @reports;
for my $xx (sort keys %EXPECT_TESTS) {
    my $name = "$PKG.$xx";
    unless (exists($seen{$name})) {
        say "# Test report missing: $name";
        say "# Giving up";
        exit(0);
    }

    my $report = JUnit::read_report($name);

    my $jvers = $report->java_version();
    say "# Java VM: $jvers";

    my $summary = $report->summary();
    my $expect = $EXPECT_TESTS{$xx};
    my $ran = $summary->{tests};
    my $good = ($ran == $expect);
    my $bad = $summary->{fails} + $summary->{errors};
    my $pass = $ran - $bad;

    unless ($ran == $expect) {
        say "# $name";
        say "# Error: expected $expect tests but ran $ran";
        next;
    }

    for (my $ii = 0; $ii < $expect; ++$ii) {
        ok($pass > $ii, "Passed > $ii tests in $name");
    }
}

use CheckStyle;

my @errors = CheckStyle->list_errors();
my $count = scalar @errors;

ok($count < 10, "Less than 10 style errors");
ok($count == 0, "No style errors");

if ($count > 0) {
    say "#";
    say "# You had some style errors, here they are:";
    for my $err (@errors) {
        my $file = $err->{file};
        $file =~ s/^.*\///;
        my $line = $err->{line};
        my $text = $err->{text};
        say "#   $file:$line => $text";
    }
}
